package com.mochasoft.fk.db.page;

/**
 * <strong>Title : DB2Dialect </strong>. <br>
 * <strong>Description : DB2数据方言，目前实现了物理分页.</strong> <br>
 * <strong>Create on : 2013-2-20 上午11:49:38 </strong>. <br>
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
public class DB2Dialect implements Dialect {
	/**
	 * (non-Javadoc).
	 * 
	 * @see com.mochasoft.fk.db.page.Dialect#getPageSql(java.lang.String, int, int)
	 */
	@Override
	public String getPageSql(String sql, int offset, int limit) {
		sql = sql.trim();
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		pagingSelect.append(" SELECT * FROM (SELECT PAGE_B.*, ROWNUMBER() OVER() AS RN FROM ( ");
		pagingSelect.append(sql);
		pagingSelect.append(" ) AS PAGE_B )AS PAGE_A WHERE PAGE_A.RN BETWEEN ").append(offset).append(" AND ")
				.append(offset + limit - 1);
		return pagingSelect.toString();
	}

}