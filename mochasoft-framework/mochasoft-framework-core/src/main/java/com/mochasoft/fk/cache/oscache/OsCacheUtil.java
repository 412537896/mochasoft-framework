package com.mochasoft.fk.cache.oscache;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.oscache.base.Cache;
import com.opensymphony.oscache.base.NeedsRefreshException;
import com.opensymphony.oscache.base.algorithm.AbstractConcurrentReadCache;
import com.opensymphony.oscache.web.ServletCacheAdministrator;

public class OsCacheUtil {

	private static final Logger log = LoggerFactory
			.getLogger(OsCacheUtil.class);

	/**
	 * 通过反射机制获取Cache私有成员变量cacheMap， 2012/10/8, by jeffsang
	 * 
	 * @return
	 */
	public static AbstractConcurrentReadCache getCacheMap(ServletContext ctx) {
		// 获取Cache对象实例
		Cache cache = ServletCacheAdministrator.getInstance(ctx)
				.getAppScopeCache(ctx);

		// 通过反射机制获取Cache私有成员变量cacheMap
		AbstractConcurrentReadCache cacheMap = null;
		try {
			Field field = Cache.class.getDeclaredField("cacheMap");
			field.setAccessible(true);
			cacheMap = (AbstractConcurrentReadCache) field.get(cache);
			field.setAccessible(false);
		} catch (Exception e) {
			log.warn("can't acquire oscache Cache.cacheMap! ", e);
		}
		return cacheMap;
	}

	/**
	 * 获取ServletCache的全部Application Scope的cache， 2012/10/8, by jeffsang
	 * 
	 * @return
	 * @throws NeedsRefreshException
	 */
	public static Map getAppScopeCaches(ServletContext ctx)
			throws NeedsRefreshException {
		Map map = new HashMap();

		// 获取Cache对象实例
		Cache cache = ServletCacheAdministrator.getInstance(ctx)
				.getAppScopeCache(ctx);

		// 通过反射机制获取Cache私有成员变量cacheMap
		AbstractConcurrentReadCache cacheMap = getCacheMap(ctx);

		// 返回包含在cacheMap中的Map关系的 Set视图。
		@SuppressWarnings("unchecked")
		Set setEntry = cacheMap.entrySet();
		Set keySet = cacheMap.keySet();
		Iterator keys = keySet.iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			Object value = cache.getFromCache(key);
			map.put(key, value);
		}

		// 使用Iterator遍历器
		// Iterator it = cacheMap.entrySet().iterator();

		// 使用for遍历cacheMap中的entrySet
		/*
		 * for (Map.Entry entry : cacheMap) { String key = entry.getKey();
		 * Object value = cache.getFromCache(key);
		 * 
		 * //以下方法只能得到CacheEntry对象实例Id //Object value = entry.getValue();
		 * 
		 * map.put(key, value); }
		 */

		return map;
	}
}
