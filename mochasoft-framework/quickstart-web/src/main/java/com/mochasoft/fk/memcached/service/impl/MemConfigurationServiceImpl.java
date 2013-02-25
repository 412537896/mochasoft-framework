//package com.mochasoft.fk.memcached.service.impl;
//
//import java.util.Iterator;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.danga.MemCached.MemCachedClient;
//import com.mochasoft.fk.configuration.entity.Configuration;
//import com.mochasoft.fk.configuration.mapper.ConfigurationMapper;
//import com.mochasoft.fk.memcached.MemClient;
//import com.mochasoft.fk.memcached.service.IMemConfigurationService;
//
//@Service
//public class MemConfigurationServiceImpl implements IMemConfigurationService {
//	
//	private static final Logger log = LoggerFactory.getLogger(MemConfigurationServiceImpl.class);
//	private MemCachedClient client = MemClient.getClient();
//	
//	@Autowired
//	private ConfigurationMapper mapper;
//
//	@Override
//	public void reload() {
//		//重新装载有问题，需要重新设计
//		//client.delete(arg0);
//		getAllConfigInfo();
//	}
//
//	public void getAllConfigInfo(){
//		List<Configuration> list = mapper.selectAll();
//		log.info(list.size()+"");
//		Iterator<Configuration> it = list.iterator();
//		
//		//放入memcached
//		while(it.hasNext()){
//			Configuration configuration = it.next();
//			client.set(configuration.getKey(), configuration.getValue());
//		}
//	}
//}
