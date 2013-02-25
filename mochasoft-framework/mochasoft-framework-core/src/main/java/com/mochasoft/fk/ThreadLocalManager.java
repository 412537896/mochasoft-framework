package com.mochasoft.fk;


/**
 * <strong>Title : ThreadLocalManager </strong>. <br>
 * <strong>Description : 线程安全管理类，用于线程内状态维护.</strong> <br>
 * <strong>Create on : 2013-2-20 上午11:44:21 </strong>. <br>
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
public class ThreadLocalManager {
	/** 
	 * <code>dbContextHolder</code> - 线程安全的ThreadLocal，存储数据源类型. 
	 */
	private static final ThreadLocal<String> dbContext = new ThreadLocal<String>();
	
	/**
	 * 线程上下文中设置当前数据源.
	 * @param dbType
	 */
	public static void setCurrentDB(String dbType) {
		dbContext.set(dbType);
	}

	/**
	 * 线程上下文中获取当前数据源.
	 * @return
	 */
	public static String getCurrentDB() {
		return ((String) dbContext.get());
	}

	/**
	 * 清楚线程上下文中数据源设置.
	 */
	public static void clearCurrentDB() {
		dbContext.remove();
	}
}
