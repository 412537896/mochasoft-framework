package com.mochasoft.example.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.mochasoft.example.entity.UserInfo;
import com.mochasoft.fk.ThreadLocalManager;
import com.mochasoft.fk.db.page.Page;
import com.mochasoft.fk.test.spring.SpringTransactionalTestCase;

@DirtiesContext
/*
 * 测试结论：
 * 1.数据源切换是支持的
 * 2.同一个线程中 不能 切换数据源
 */
public class DynamicDataSourceTest extends SpringTransactionalTestCase {
	@Autowired
	private UserInfoService service;
	
	@Test
	@Ignore
	public void testGetUserXZ() {
		ThreadLocalManager.setCurrentDB("dataSourceXZ");
		List<UserInfo> list = service.list();
		System.out.println(list);
		System.out.println(list.size());
		assertTrue(list != null);
		assertTrue(list.size() ==7);
		System.out.println("############################################");
	}
	
	@Test
	public void testGetUserHN() {
		System.out.println("############################################");
		ThreadLocalManager.setCurrentDB("dataSourceHN");
//		List<UserInfo> list1 = service.list();
		List<UserInfo> list1 = service.list(new Page(1,3));
		System.out.println(list1);
		System.out.println(list1.size());
		assertTrue(list1 != null);
		assertTrue(list1.size() ==3);
	}
}
