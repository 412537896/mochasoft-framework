package com.mochasoft.fk.test.memcached;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import com.mochasoft.fk.configuration.entity.Configuration;
import com.mochasoft.fk.configuration.service.IConfigurationService;
import com.mochasoft.fk.test.spring.SpringTransactionalTestCase;

@DirtiesContext
public class SpringMemcachedTest extends SpringTransactionalTestCase {
	
	@Autowired
	IConfigurationService service;
	
	CacheManager manager = null;
	
	@Test
	public void testSelectByKey() throws Exception{
		long start = System.currentTimeMillis();
		String configuration = service.selectByKey("key1");
		System.out.println(configuration);
		long end = System.currentTimeMillis();
		
		System.out.println("test1:" + (end - start));
		
		long start1 = System.currentTimeMillis();
		String configuration1 = service.selectByKey("key1");
		System.out.println(configuration1);
		long end1 = System.currentTimeMillis();
		
		System.out.println("test1:" + (end1 - start1));
		
		
	}
	
	@Test
	public void testDelete(){
		long start = System.currentTimeMillis();
		service.deleteByKey("key6");
		long end = System.currentTimeMillis();
		
		System.out.println("test1:" + (end - start));
	}
	
	@Test
	public void testAdd(){
		Configuration entity = new Configuration();
		entity.setKey("key7");
		entity.setValue("value7");
		entity.setType("1");
		entity.setLastupdatetime(System.currentTimeMillis());
		service.add(entity);
	}
	
	@Test
	public void testSelectByPrimaryKey(){
		long start = System.currentTimeMillis();
		Configuration entity = service.selectByPrimaryKey("bb2749b0-5f89-48e0-a3a3-7c23da045452");
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		//entity.setValue("value9");
		//entity.setLastupdatetime(System.currentTimeMillis());
		//service.update(entity);
		long start1 = System.currentTimeMillis();
		service.selectByPrimaryKey("bb2749b0-5f89-48e0-a3a3-7c23da045452");
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1);
		
		if(manager == null){
			manager = CacheManager.getInstance();
		}
		
		Cache cache = manager.getCache("ehcache");
		List list = cache.getKeys();
		String element = (String) list.get(0);
//		Object value = element.getObjectValue();
		System.out.println(element);
	}
	
	@Test
	public void testSelectAll(){
		long start = System.currentTimeMillis();
		List configuration = service.selectAll();
		long end = System.currentTimeMillis();
		
		System.out.println("test1:" + (end - start));
		
		long start1 = System.currentTimeMillis();
		List configuration1 = service.selectAll();
		long end1 = System.currentTimeMillis();
		
		System.out.println("test1:" + (end1 - start1));
		
		service.selectByPrimaryKey("bb2749b0-5f89-48e0-a3a3-7c23da045452");
		
		service.selectByKey("key1");
		
		if(manager == null){
			manager = CacheManager.getInstance();
		}
		
		Cache cache = manager.getCache("ehcache");
		List list = cache.getKeys();
		Object element = (Object) list.get(0);
//		Object value = element.getObjectValue();
		System.out.println(list.size());
	}
	
	@Test
	public void flushAll(){
		service.flushCacheAll();
	}
	
}
