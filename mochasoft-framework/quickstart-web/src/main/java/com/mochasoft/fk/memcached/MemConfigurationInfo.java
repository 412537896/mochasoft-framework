package com.mochasoft.fk.memcached;

import java.util.List;

import net.spy.memcached.MemcachedClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

import com.mochasoft.fk.configuration.entity.Configuration;
import com.mochasoft.fk.configuration.service.IConfigurationService;
import com.mochasoft.fk.configuration.service.impl.ConfigurationServiceImpl;

public class MemConfigurationInfo {
	
	private static final Logger log = LoggerFactory.getLogger(MemConfigurationInfo.class);
	
	private IConfigurationService service;
	private MemcachedClient client;
	MemcachedCache cache;
	
	public MemConfigurationInfo(WebApplicationContext springContext){
		client = (MemcachedClient)springContext.getBean("memcachedClient");
		service = springContext.getBean(ConfigurationServiceImpl.class);
		cache = new MemcachedCache("memCache", client, 3600);
	}
	
	/**
	 * 获取键值对放入memcached中
	 * 
	 */
	public void putAllConfigToMemcached(){
		if(log.isInfoEnabled())
			log.info("putAllConfigToMemcached");
		List<Configuration> list = service.selectAll();
		for(Configuration configuration : list){
			cache.put(configuration.getKey(), configuration.getValue());
		}
	}
}
