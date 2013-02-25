package com.mochasoft.fk.db.page;

/**
 * <strong>Title : OracleDialect </strong>. <br>
 * <strong>Description : Oracle数据库方言，目前实现了物理分页.</strong> <br>
 * <strong>Create on : 2013-2-20 上午11:50:41 </strong>. <br>
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
public class OracleDialect implements Dialect {

	/**
	 * (non-Javadoc).
	 * 
	 * @see com.mochasoft.fk.db.page.Dialect#getPageSql(java.lang.String, int, int)
	 */
	@Override
	public String getPageSql(String sql, int offset, int pageSize) {
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		pagingSelect.append(" select * from ( select row_.*, rownum rownum_ from ( ")
					.append(sql)		
					.append(" ) row_ ) where rownum_ > ")
					.append(offset)
					.append(" and rownum_ <= ")
					.append(offset + pageSize);
		return pagingSelect.toString();
	}
}