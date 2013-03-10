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
	
	@Test
	public void testPut(){
		CacheUtils.put("test", new String("test"));
		testGet();
	}
	
	public void testGet(){
		Assert.assertEquals(CacheUtils.get("test").toString(), "test");
		testRomove();
	}
	
	public void testRomove(){
		CacheUtils.remove("test");
		Assert.assertNull(CacheUtils.get("test"));
	}
}
