package com.mochasoft.fk.cache.ehcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

public class EhcacheCache implements Cache {
	
	private static final Logger log = LoggerFactory.getLogger(EhcacheCache.class);
	
	private AbstractCacheManager cacheManager;
	private String name;
	
	public EhcacheCache() {
	}
	
	@Override
	public String getName() {
		if(name == null){
			return "defalut";
		}
		return name;
	}
	
	@Override
	public Object getNativeCache() {
		return cacheManager;
	}

	@Override
	public ValueWrapper get(Object key) {
		return getCache().get(key);
	}

	@Override
	public void put(Object key, Object value) {
		getCache().put(key, value);
	}

	@Override
	public void evict(Object key) {
		getCache().evict(key);
	}

	@Override
	public void clear() {
		getCache().clear();
	}
	
	private Cache getCache() {
		return cacheManager.getCache(name);
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
