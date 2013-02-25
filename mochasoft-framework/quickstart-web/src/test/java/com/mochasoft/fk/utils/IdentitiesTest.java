package com.mochasoft.fk.utils;

import org.junit.Assert;
import org.junit.Test;

public class IdentitiesTest {
	
	@Test
	public void testUUID() {
		String uuid = Identities.uuid();
		System.out.println(uuid);
		Assert.assertTrue(uuid.length() == 36);
	}

}
