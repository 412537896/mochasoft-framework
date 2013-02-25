package com.mochasoft.fk.security.mapper;

import org.junit.Test;

import com.mochasoft.fk.utils.Identities;

public class UUIDTest {
	
	@Test
	public void testUUID() {
		String uuid = Identities.uuid();
		//JDK自带的UUID, 通过Random数字生成, 中间有-分割.
		System.out.println(uuid);
		System.out.println(uuid.length());
	}

}
