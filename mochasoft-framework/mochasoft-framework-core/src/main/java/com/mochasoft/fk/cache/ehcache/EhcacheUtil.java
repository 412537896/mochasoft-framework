package com.mochasoft.fk.cache.ehcache;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

public class EhcacheUtil {
	
	private static CacheManager ehcacheManager = CacheManager.getInstance();
	
	private static ConcurrentMap<String, Ehcache> ehcaches;
	
	public static String[] getCacheNames(){
		return ehcacheManager.getCacheNames();
	}
	
	public static Map getAppCaches(){
		
		try {
			Field field = CacheManager.class.getDeclaredField("ehcaches");
			field.setAccessible(true);
			ehcaches = (ConcurrentMap<String, Ehcache>) field.get(ehcacheManager);
			field.setAccessible(false);
			Ehcache ehcache = ehcaches.get("ehcache");
			boolean flag = ehcaches.get("ehcache") instanceof Cache;
			System.out.println(flag);
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		Map map = new HashMap();
		String[] cacheNames = getCacheNames();
		for (int i = 0; i < cacheNames.length; i++) {
			String cacheName = cacheNames[i];
			Cache cache = getCache(cacheName);
			map.put(cacheName, cache);
		}
		return map;
	}
	
	public static Cache getCache(String cacheName){
		Cache cache = ehcacheManager.getCache(cacheName);
		return cache;
	}
}
