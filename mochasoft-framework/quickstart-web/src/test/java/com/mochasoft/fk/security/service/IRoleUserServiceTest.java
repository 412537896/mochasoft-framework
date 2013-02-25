package com.mochasoft.fk.security.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.mochasoft.fk.test.spring.SpringTransactionalTestCase;

@DirtiesContext
public class IRoleUserServiceTest extends SpringTransactionalTestCase {

	@Autowired
	private IRoleUserService service;

	@Test
	public void testSelectByUserId() {
		List<String> list = service.selectByUserId("admin");
		Assert.assertTrue(list!=null && list.size() > 0);
	}
	
}
