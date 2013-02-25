//package com.mochasoft.fk.memcached;
//
//import java.util.Iterator;
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.danga.MemCached.MemCachedClient;
//import com.mochasoft.fk.configuration.ConfigurationInfo;
//import com.mochasoft.fk.configuration.entity.Configuration;
//import com.mochasoft.fk.configuration.service.IConfigurationService;
//
//public class MemConfigurationInfo {
//	
//private static final Logger log = LoggerFactory.getLogger(ConfigurationInfo.class);
//	
//	@Autowired
//	private IConfigurationService service;
//	private MemCachedClient client;
//
//	public MemConfigurationInfo() {
//		client = MemClient.getClient();
//	}
//	
//	public void setService(IConfigurationService service) {
//		this.service = service;
//	}
//	
//	/**
//	 * 放入memcached
//	 */
//	public void getAllConfigInfo(){
//		List<Configuration> list = service.selectAll();
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
