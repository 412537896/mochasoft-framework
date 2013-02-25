package com.mochasoft.fk.db.page;

/**
 * <strong>Title : Mysql5Dialect </strong>. <br>
 * <strong>Description : Mysql数据库方言，目前实现了物理分页.</strong> <br>
 * <strong>Create on : 2013-2-20 上午11:50:19 </strong>. <br>
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
public class Mysql5Dialect implements Dialect {

	/**
	 * (non-Javadoc).
	 * 
	 * @see com.mochasoft.fk.db.page.Dialect#getPageSql(java.lang.String, int, int)
	 */
	@Override
	public String getPageSql(String sql, int offset, int pageSize) {
		return sql + " limit " + offset + "," + pageSize;
	}

}
