package com.mochasoft.fk.cache.ehcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

public class EhcacheCache implements Cache {
	
	private static final Logger log = LoggerFactory.getLogger(EhcacheCache.class);
	
	private AbstractCacheManager cacheManager;
	private String name;
	private Cache cache;
	
	public EhcacheCache() {
	}
	
	@Override
	public String getName() {
		if(name == null){
			return "ehcache";
		}
		return name;
	}
	
	@Override
	public Object getNativeCache() {
		return cacheManager;
	}

	@Override
	public ValueWrapper get(Object key) {
		log.debug("get:" + key);
		ValueWrapper wrapper = getCache().get(key);
//		if(wrapper.get() == null){
//			return null;
//		}
		return wrapper;
	}

	@Override
	public void put(Object key, Object value) {
		log.debug("put:" + key + " | " + value);
		getCache().put(key, value);
	}

	@Override
	public void evict(Object key) {
		log.debug("evict:" + key);
		getCache().evict(key);
	}

	@Override
	public void clear() {
		log.debug("clear");
		getCache().clear();
	}
	
	private Cache getCache() {
		log.debug(name);
		cache = cacheManager.getCache(name);
		return cache;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AbstractCacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(AbstractCacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

}
