package com.mochasoft.fk.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.builder.xml.dynamic.ForEachSqlNode;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mochasoft.fk.db.page.Dialect;
import com.mochasoft.fk.db.page.Mysql5Dialect;
import com.mochasoft.fk.db.page.OracleDialect;
import com.mochasoft.fk.db.page.Page;
import com.mochasoft.fk.exception.MochaException;

/**
 * <strong>Title : PaginationInterceptor </strong>. <br>
 * <strong>Description : MyBatis物理分页拦截器.</strong> <br>
 * <strong>Create on : 2013-2-6 下午4:52:49 </strong>. <br>
 * <p>
 * <strong>Copyright (C) Mocha Software Co.,Ltd.</strong> <br>
 * </p>
 * @author wanghe wanghe@mochasoft.com.cn <br>
 * @version <strong>FrameWork v0.8</strong> <br>
 * <br>
 * <strong>修改历史: .</strong> <br>
 * 修改人 修改日期 修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
		RowBounds.class, ResultHandler.class }) })
public class PaginationInterceptor implements Interceptor {

	protected static Logger logger = LoggerFactory.getLogger(PaginationInterceptor.class);
	// 获取方言配置
	private static Dialect dialect = null;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		Object parameter = invocation.getArgs()[1];
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);
		// 如果sql为空，直接返回空对象
		if (boundSql == null || boundSql.getSql() == null || "".equals(boundSql.getSql())) {
			return null;
		}

		String originalSql = boundSql.getSql().trim();
		Object parameterObject = boundSql.getParameterObject();

		// 获取分页对象
		Page page = getPage(parameterObject);
		// 分页执行if逻辑
		if (page != null && page.isPagination() == true) {
			Configuration configuration = mappedStatement.getConfiguration();
			// 如果没设置总记录数量，则重新查询一次，得到总记录数
			if (page.getTotalRows() == 0) {
				StringBuffer countSql = new StringBuffer(originalSql.length() + 100);
				countSql.append("select count(1) from (").append(originalSql).append(") t");
				Connection connection = configuration.getEnvironment().getDataSource().getConnection();
				PreparedStatement countStmt = connection.prepareStatement(countSql.toString());
				BoundSql countBS = new BoundSql(configuration, countSql.toString(),
											boundSql.getParameterMappings(), parameterObject);
				setParameters(countStmt, mappedStatement, countBS, parameterObject);
				ResultSet rs = countStmt.executeQuery();
				if (rs.next()) {
					page.setTotalRows(rs.getInt(1));
				}
				rs.close();
				countStmt.close();
				connection.close();
			}
			if(page.getTotalRows() > page.getPageSize()) {
				// 获取方言配置
				if (dialect == null) {
					dialect = getDialect(configuration);
				}
				// 分页查询 本地化对象 修改数据库注意修改实现
				String pagesql = dialect.getPageSql(originalSql, page.getPageStartRow(), page.getPageSize());
				BoundSql newBoundSql = new BoundSql(mappedStatement.getConfiguration(), pagesql,
						boundSql.getParameterMappings(), boundSql.getParameterObject());
				if (logger.isDebugEnabled()) {
					logger.debug("生成分页SQL : " + newBoundSql.getSql());
				}
				MappedStatement newMs = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql));
				invocation.getArgs()[0] = newMs;
			}
		}
		return invocation.proceed();
	}

	/**
	 * 分页方言，目前支持oracle和mysql.
	 * @param configuration
	 * @return
	 */
	private Dialect getDialect(Configuration configuration) {
		Dialect.Type databaseType = null;
		try {
			databaseType = Dialect.Type.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());
		} catch (Exception e) {
			// ignore
		}
		if (databaseType == null) {
			throw new MochaException("the value of the dialect property in configuration.xml is not defined : "
					+ configuration.getVariables().getProperty("dialect"));
		}
		Dialect dialect = null;
		switch (databaseType) {
		case ORACLE:
			dialect = new OracleDialect();
			break;
		case MYSQL:
			dialect = new Mysql5Dialect();
			break;
		default:
			dialect = new OracleDialect();
		}
		return dialect;
	}

	/**
	 * 支持两种分页参数. 1.Mapper的参数为 java.util.Map， 并且 map中包含 page属性
	 * 2.pageContext中设置使用分页
	 * 
	 * @param parameterObject
	 * @return
	 */
	private Page getPage(Object parameterObject) {
		// 分页参数--上下文传参
		Page page = null;
		// map传参每次都将currentPage重置,先判读map再判断context
		if (parameterObject != null) {
			page = (Page) isPage(parameterObject);
		}
		return page;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}

	public static class BoundSqlSqlSource implements SqlSource {
		BoundSql boundSql;

		public BoundSqlSqlSource(BoundSql boundSql) {
			this.boundSql = boundSql;
		}

		public BoundSql getBoundSql(Object parameterObject) {
			return boundSql;
		}
	}

	/**
	 * 对SQL参数(?)设值,参考org.apache.ibatis.executor.parameter.
	 * DefaultParameterHandler
	 * 
	 * @param ps
	 * @param mappedStatement
	 * @param boundSql
	 * @param parameterObject
	 * @throws SQLException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		if (parameterMappings != null) {
			Configuration configuration = mappedStatement.getConfiguration();
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			MetaObject metaObject = parameterObject == null ? null : configuration.newMetaObject(parameterObject);
			for (int i = 0; i < parameterMappings.size(); i++) {
				ParameterMapping parameterMapping = parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT) {
					Object value;
					String propertyName = parameterMapping.getProperty();
					PropertyTokenizer prop = new PropertyTokenizer(propertyName);
					if (parameterObject == null) {
						value = null;
					} else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
						value = parameterObject;
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						value = boundSql.getAdditionalParameter(propertyName);
					} else if (propertyName.startsWith(ForEachSqlNode.ITEM_PREFIX)
							&& boundSql.hasAdditionalParameter(prop.getName())) {
						value = boundSql.getAdditionalParameter(prop.getName());
						if (value != null) {
							value = configuration.newMetaObject(value).getValue(
									propertyName.substring(prop.getName().length()));
						}
					} else {
						value = metaObject == null ? null : metaObject.getValue(propertyName);
					}
					TypeHandler typeHandler = parameterMapping.getTypeHandler();
					if (typeHandler == null) {
						throw new ExecutorException("There was no TypeHandler found for parameter " + propertyName
								+ " of statement " + mappedStatement.getId());
					}
					typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());
				}
			}
		}
	}

	//copy产生新的MappedStatement，作用为了使用新的分页SQL
	private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
		Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource,
				ms.getSqlCommandType());
		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		builder.keyProperty(convertArrayToString(ms.getKeyProperties()));
		builder.timeout(ms.getTimeout());
		builder.parameterMap(ms.getParameterMap());
		builder.resultMaps(ms.getResultMaps());
		builder.cache(ms.getCache());
		MappedStatement newMs = builder.build();
		return newMs;
	}
	
	private String convertArrayToString(String[] in) {
		String returnStr = null;
		if (in == null || in.length == 0) {
			returnStr = null;;
		} else {
			StringBuilder builder = new StringBuilder();
			for (String str : in) {
				builder.append(str)
						.append(",");
			}
			if(builder.length() > 0 && builder.indexOf(",") != -1) {
				//说明含有,，并且一定以,结尾，此时去掉一个字符
				returnStr = builder.substring(0, builder.lastIndexOf(","));
			}
		}
		return returnStr;
	}
	
	 /**
     * 检查是否含有分页或本来就是分页类
     * @param obj
     * @param fieldName
     * @return
     */
    @SuppressWarnings({ "rawtypes" })
	private Object isPage(Object obj) {
    	//有多个参数，参数中有一个是Page对象
		if (obj instanceof Map) {
			Map map = (Map)obj;
			Iterator iter = map.values().iterator();
			while(iter.hasNext()) {
				Object o = iter.next();
				if(o instanceof Page) {
					return o;
				}
			}
		} else {
			Object o = obj;
			if(o instanceof Page) {
				return obj;
			} 
    	}
		return null;
      
    } 
}
