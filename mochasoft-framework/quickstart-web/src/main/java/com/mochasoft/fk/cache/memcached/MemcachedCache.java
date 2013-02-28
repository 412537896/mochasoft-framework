package com.mochasoft.fk.cache.memcached;

import java.util.concurrent.ExecutionException;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

/**
 * 实现Spring Cache接口，扩展memcached
 * 
 * @author yaofeng
 *
 */
public class MemcachedCache implements Cache {
	
	private static final Logger log = LoggerFactory.getLogger(MemcachedCache.class);
	
	private String name;
	private MemcachedClient client;
	private int expiry = 3600;
	
	public MemcachedCache() {
	}
	
	public MemcachedCache(String name, MemcachedClient client, int expiry) {
		this.name = name;
		this.client = client;
		this.expiry = expiry;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Object getNativeCache() {
		return client;
	}

	/**
	 * 转换key为String类型
	 * 
	 * @param key
	 * @return
	 */
	private static String keyToString(Object key) {
		if (key == null) {
			return null;
		} else if (key instanceof String) {
			return (String) key;
		} else {
			return key.toString();
		}
	}

	public ValueWrapper get(Object key) {
		Object value = client.get(keyToString(key));
		if(log.isDebugEnabled()){
			log.debug("获取"+ key + ":" + value);
		}
		if(value == null){
			return null;
		}
		return new SimpleValueWrapper(value);
	}

	public void put(Object key, Object value) {
		if(log.isDebugEnabled()){
			log.debug("缓存 |"+ key + ":" + value + "| 开始");
		}
		OperationFuture<Boolean> of = client.set(keyToString(key), expiry, value);
		try {
			of.get();
			if(log.isDebugEnabled()){
				log.debug("缓存 |"+ key + ":" + value + "| 成功");
			}
		} catch (InterruptedException e) {
			of.cancel();
			if(log.isDebugEnabled()){
				log.debug("缓存 |"+ key + ":" + value + "| 失败");
			}
			e.printStackTrace();
		} catch (ExecutionException e) {
			of.cancel();
			if(log.isDebugEnabled()){
				log.debug("缓存 |"+ key + ":" + value + "| 失败");
			}
			e.printStackTrace();
		}
	}

	public void evict(Object key) {
		if(log.isDebugEnabled()){
			log.debug("删除缓存 :"+ key);
		}
		OperationFuture<Boolean> of = client.delete(keyToString(key));
		try {
			of.get();
			if(log.isDebugEnabled()){
				log.debug("删除缓存 :"+ key + "|成功");
			}
		} catch (InterruptedException e) {
			of.cancel();
			if(log.isDebugEnabled()){
				log.debug("删除缓存 :"+ key + "|失败");
			}
			e.printStackTrace();
		} catch (ExecutionException e) {
			of.cancel();
			if(log.isDebugEnabled()){
				log.debug("删除缓存 :"+ key + "|失败");
			}
			e.printStackTrace();
		}
	}

	public void clear() {
		if(log.isDebugEnabled()){
			log.debug("清空缓存开始");
		}
		OperationFuture<Boolean> of = client.flush();
		try {
			of.get();
			if(log.isDebugEnabled()){
				log.debug("清空缓存完成！");
			}
		} catch (InterruptedException e) {
			of.cancel();
			if(log.isErrorEnabled()){
				log.error("清空缓存失败！");
			}
			e.printStackTrace();
		} catch (ExecutionException e) {
			of.cancel();
			if(log.isErrorEnabled()){
				log.error("清空缓存失败！");
			}
			e.printStackTrace();
		}
	}

	public void setClient(MemcachedClient client) {
		this.client = client;
	}

	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}

}
