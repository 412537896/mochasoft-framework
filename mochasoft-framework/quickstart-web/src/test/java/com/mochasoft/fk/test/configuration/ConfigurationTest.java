package com.mochasoft.fk.test.configuration;

import java.util.UUID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.mochasoft.fk.configuration.entity.Configuration;
import com.mochasoft.fk.configuration.service.IConfigurationService;
import com.mochasoft.fk.test.spring.SpringTransactionalTestCase;

@DirtiesContext
public class ConfigurationTest extends SpringTransactionalTestCase {
	
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
