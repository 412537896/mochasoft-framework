package com.mochasoft.example.mapper;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mochasoft.example.entity.User;
import com.mochasoft.example.service.UserService;
import com.mochasoft.example.test.data.UserData;

/**
 * <strong>Title : TransactionTest </strong>. <br>
 * <strong>Description : 事务完整性测试类，因为其他的 测试类使用了spring-test，不会写数据进入数据库.</strong> <br>
 * <strong>Create on : 2012-12-29 下午8:27:15 </strong>. <br>
 * <p>
 * <strong>Copyright (C) Mocha Software Co.,Ltd.</strong> <br>
 * </p>
 * @author wanghe wanghe@mochasoft.com.cn <br>
 * @version <strong>Framework0.0.1</strong> <br>
 * <br>
 * <strong>修改历史: .</strong> <br>
 * 修改人 修改日期 修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
public class TransactionTest {
	
	private static UserService userService;
	private static AbstractApplicationContext context;
	
	@BeforeClass
	public static void before() {
		context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext*.xml");
		userService = context.getBean(UserService.class);
	}
	
	@Test
	public void getUser() throws Exception {
		User user = userService.getUser(1L);
		if(user != null) {
			assertEquals("admin", user.getLoginName());
		}
	}

	@Test
	public void testUpdate() throws Exception {
		User user = UserData.randomUser();
		try {
			user.setId(24L);
			userService.updateUser(user);
		} catch (Throwable able) {
			able.printStackTrace();
			Assert.fail();
		}
	}
	
	@AfterClass
	public static void after() {
		context.close();
	}
	
	

}
