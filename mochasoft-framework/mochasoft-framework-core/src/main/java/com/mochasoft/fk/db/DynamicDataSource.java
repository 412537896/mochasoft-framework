package com.mochasoft.fk.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.mochasoft.fk.ThreadLocalManager;

/**
 * <strong>Title : DynamicDataSource </strong>. <br>
 * <strong>Description : 动态数据源切换实现.</strong> <br>
 * 通过获取线程上下文数据源信息 获取 应该使用的数据源
 * <strong>Create on : 2013-2-20 上午11:48:20 </strong>. <br>
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
public class DynamicDataSource extends AbstractRoutingDataSource {
	@Override
	 public Object determineCurrentLookupKey() {
	    return  ThreadLocalManager.getCurrentDB();
	 }
}
