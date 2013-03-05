package com.mochasoft.fk.configuration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mochasoft.fk.configuration.entity.Configuration;
import com.mochasoft.fk.configuration.service.IConfigurationService;

public class ConfigurationInfo {
	
	private static final Logger log = LoggerFactory.getLogger(ConfigurationInfo.class);
	
	private static ConfigurationInfo info = null;
	private IConfigurationService service;
	private Map<String, Object> config = new HashMap<String, Object>();
	
	private ConfigurationInfo(){
	}
	
	public void setService(IConfigurationService service) {
		this.service = service;
	}

	/**
	 * 单例获取ConfigurationInfo对象
	 * 
	 * @return
	 */
	public static ConfigurationInfo getInstance(){
		if(info == null){
			info = new ConfigurationInfo();
		}
		return info;
	}
	
	/**
	 * 根据key获取value值
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key){
		Configuration configuration = null;
		@SuppressWarnings("unchecked")
		List<Configuration> list = (List<Configuration>)config.get("dbconfig");
		if(list != null && list.size() != 0){
			Iterator<Configuration> iterator = list.iterator();
			while(iterator.hasNext()){
				configuration = iterator.next();
				if(key.equals(configuration.getKey())){
					return configuration.getValue();
				}
			}
		}
		return "";
	}
	
	/**
	 * 全部重新获取
	 */
	public void reloadAll(){
		config.clear();
		//getAllConfigInfo();
	}
	
	/**
	 * 获取键值对放入map中
	 * 之所以用map，是考虑有可能从properties文件中读入键值对时，可复用此方法
	 */
	private void getAllConfigInfo(){
		service.flushCacheAll();
		List<Configuration> list = service.selectAll();
		config.put("dbconfig", list);
		log.info(list.size()+"");
	}
}
