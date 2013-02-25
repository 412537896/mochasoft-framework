package com.mochasoft.fk.test.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * <strong>Title : SpringTransactionalTestCase </strong>. <br>
 * <strong>Description : Spring的支持数据库访问, 事务控制和依赖注入的JUnit4 集成测试基类.</strong> <br>
 * 相比Spring原基类名字更短并保存了dataSource变量.<br>
 * 子类可以重新定义applicationContext文件的位置, 如:<br>
 * @ContextConfiguration(locations = { "/applicationContext.xml" })
 * <strong>Create on : 2013-1-5 上午11:42:58 </strong>. <br>
 * <p>
 * <strong>Copyright (C) Mocha Software Co.,Ltd.</strong> <br>
 * </p>
 * @author wanghe wanghe@mochasoft.com.cn <br>
 * @version <strong>Framework0.8</strong> <br>
 * <br>
 * <strong>修改历史: .</strong> <br>
 * 修改人 修改日期 修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@ContextConfiguration(locations = { "/applicationContext.xml", "/applicationContext-fk.xml"})
public abstract class SpringTransactionalTestCase extends AbstractTransactionalJUnit4SpringContextTests {

	protected DataSource dataSource;

	@Override
	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		this.dataSource = dataSource;
	}
}
