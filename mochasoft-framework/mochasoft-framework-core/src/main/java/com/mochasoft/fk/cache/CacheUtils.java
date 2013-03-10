package com.mochasoft.fk.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class CacheUtils implements ApplicationContextAware {
	
	private static final Logger log = LoggerFactory.getLogger(CacheUtils.class);
	private static final String default_cache = "ehcache";
	
	private static SimpleCacheManager cacheManager = null;   

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		cacheManager = (SimpleCacheManager) applicationContext.getBean("cacheManager");
	}
	
	public static Object get(String key){
		return get(default_cache, key);
	}
	
	public static Object get(String cacheName, String key){
		org.springframework.cache.Cache cache = cacheManager.getCache(cacheName);
		return cache.get(key) == null ? null : cache.get(key).get();
	}
	
	public static void put(String cacheName, String key, Object value){
		cacheManager.getCache(cacheName).put(key, value);
	}
	
	public static void put(String key, Object value){
		put(default_cache, key, value);
	}
	
	public static void remove(String cachaName, String key){
		cacheManager.getCache(cachaName).evict(key);
	}
	
	public static void remove(String key){
		remove(default_cache, key);
	}

}
