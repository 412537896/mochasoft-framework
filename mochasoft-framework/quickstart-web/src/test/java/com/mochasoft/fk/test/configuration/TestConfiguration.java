package com.mochasoft.fk.test.configuration;

import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mochasoft.fk.configuration.entity.Configuration;
import com.mochasoft.fk.configuration.service.IConfigurationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring-conf/*.xml", "classpath:/spring-servlet/*.xml", "classpath:/spring-security/*.xml"})
public class TestConfiguration {
	
	@Autowired
	private IConfigurationService service;
	
	@Test
	public void testAddConfig(){
		Configuration entity = new Configuration();
		entity.setId(UUID.randomUUID().toString());
		entity.setType("1");
		entity.setKey("key5");
		entity.setValue("value5");
		entity.setLastupdatetime(System.currentTimeMillis());
		
		
		service.add(entity);
	}
	
	@Test
	public void testSelectByKey(){
		//List<Configuration> list = service.selectAll();
		String configuration = service.selectByKey("key1");
		System.out.println(configuration);
	}
}
