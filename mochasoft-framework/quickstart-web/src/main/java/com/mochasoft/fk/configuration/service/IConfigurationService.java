package com.mochasoft.fk.configuration.service;

import java.util.List;

import com.mochasoft.fk.configuration.entity.Configuration;

public interface IConfigurationService {
	
	/**
	 * 根据键值获取配置信息
	 * 
	 * @param key
	 * @return
	 */
	public String selectByKey(String key);
	
	/**
	 * 根据键值删除配置信息
	 * 
	 * @param key
	 */
	public void deleteByKey(String key);
	
	/**
	 * 清空所有缓存
	 */
	public void flushCacheAll();
	
	public String add(Configuration entity);
	
	public String update(Configuration entity);
	
	int deleteByPrimaryKey(String id);
	
	Configuration selectByPrimaryKey(String id);
	
	List<Configuration> selectAll();
}
