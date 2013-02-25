package com.mochasoft.example.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mochasoft.example.entity.UserInfo;
import com.mochasoft.fk.exception.MochaException;

public class UserInfoServiceTest {
	
	private static UserInfoService service;
	private static AbstractApplicationContext context;
	
	@BeforeClass
	public static void before() {
		context = new ClassPathXmlApplicationContext(
				"classpath:/spring-conf/applicationContext*.xml",
				"classpath:/applicationContext*.xml");
		service = context.getBean(UserInfoService.class);
	}

	@Test
	public void testAdd() {
		UserInfo bean = new UserInfo();
		bean.setId(35);
		bean.setUsername("wangzhg");
		bean.setPassword("000000");
		bean.setEmail("wangzhg@mochasoft.com.cn");
		bean.setMobile("13512215790");
		
		try {
			service.add(bean);
		}  catch (MochaException e) {
			e.printStackTrace();
			Assert.fail("testAdd error");
		}
	}
	
	@Test
	public void testList() {
		try {
			List<UserInfo> userInfos = service.list();
			System.out.println(userInfos);
		} catch (MochaException e) {
			e.printStackTrace();
			Assert.fail("testList error");
		}
	}
	
	@Test
	public void testDeleteById() {
		try {
			service.deleteById(1);
		} catch (MochaException e) {
			e.printStackTrace();
			Assert.fail("testAdd testDeleteById");
		}
	}
	
	@AfterClass
	public static void after() {
		context.close();
	}

}
