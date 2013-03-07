package com.mochasoft.fk.configuration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

import com.mochasoft.fk.configuration.entity.Configuration;
import com.mochasoft.fk.configuration.service.IConfigurationService;
import com.mochasoft.fk.configuration.service.impl.ConfigurationServiceImpl;

public class EhcacheConfigurationInfo {
	
	private static final Logger log = LoggerFactory.getLogger(EhcacheConfigurationInfo.class);
	
	private IConfigurationService service;
	
	public EhcacheConfigurationInfo(WebApplicationContext springContext) {
		service = springContext.getBean(ConfigurationServiceImpl.class);
	}
	
	/**
	 * 获取键值对放入ehcache中
	 * 
	 */
	public void putAllConfigToMemcached(){
		if(log.isInfoEnabled())
			log.info("putAllConfigToMemcached");
		List<Configuration> list = service.selectAll();
		for(Configuration configuration : list){
			//cache.put(configuration.getKey(), configuration.getValue());
			service.selectByKey(configuration.getKey());
		}
	}
}
