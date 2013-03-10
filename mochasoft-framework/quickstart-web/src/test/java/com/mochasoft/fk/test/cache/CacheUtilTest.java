package com.mochasoft.fk.test.cache;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mochasoft.fk.cache.CacheUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class CacheUtilTest {
	
	//存放缓存
	@Test
	public void testPut(){
		//存入默认缓存名称为ehcache缓存中
		CacheUtils.put("test", new String("test"));
		//存入指定缓存名称的缓存中
		CacheUtils.put("ehcache1", "test1", new String("test1"));
		testGet();
	}
	
	//获取缓存
	public void testGet(){
		//从默认ehcache中获取缓存
		Assert.assertEquals(CacheUtils.get("test").toString(), "test");
		//从指定缓存中换取缓存
		Assert.assertEquals(CacheUtils.get("ehcache1", "test1"), "test1");
		testRomove();
	}
	
	//清除缓存
	public void testRomove(){
		//删除默认ehcache中的缓存
		CacheUtils.remove("test");
		Assert.assertNull(CacheUtils.get("test"));
		//删除指定缓存中的缓存
		CacheUtils.remove("ehcache1","test1");
		Assert.assertNull(CacheUtils.get("test1"));
		
	}
}
