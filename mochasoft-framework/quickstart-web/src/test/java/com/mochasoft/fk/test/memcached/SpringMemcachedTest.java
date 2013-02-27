package com.mochasoft.fk.test.memcached;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mochasoft.fk.configuration.entity.Configuration;
import com.mochasoft.fk.configuration.service.IConfigurationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SpringMemcachedTest {
	
	@Autowired
	IConfigurationService service;
	
	@Test
	public void testSelectByKey() throws Exception{
		long start = System.currentTimeMillis();
		String configuration = service.selectByKey("key1");
		System.out.println(configuration);
		long end = System.currentTimeMillis();
		
		System.out.println("test:" + (end - start));
		
	}
	
	@Test
	public void testDelete(){
		long start = System.currentTimeMillis();
		service.deleteByKey("key6");
		long end = System.currentTimeMillis();
		
		System.out.println("test1:" + (end - start));
	}
	
	@Test
	public void testAdd(){
		Configuration entity = new Configuration();
		entity.setKey("key6");
		entity.setValue("value6");
		entity.setType("1");
		entity.setLastupdatetime(System.currentTimeMillis());
		service.add(entity);
	}
	
	@Test
	public void testUpdate(){
		Configuration entity = service.selectByPrimaryKey("6972b632-50cc-45de-8f56-547bed2e2063");
		entity.setValue("value9");
		entity.setLastupdatetime(System.currentTimeMillis());
		service.update(entity);
	}
	
	@Test
	public void flushAll(){
		service.flushCacheAll();
	}
	
}
