package com.mochasoft.fk.utils;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;

public class NowDateTest {
	
	@Test
	public void getNowDateLong() {
		long now = System.currentTimeMillis();
		System.out.println(now);
		Assert.assertTrue(String.valueOf(now).length() == 13);
	}
	
	@Test
	public void dateToLong() throws ParseException {
		String time = "2013-07-01 00:00:00";
		Date datetime = DateUtils.parseDate(time, "yyyy-mm-dd HH:MM:SS");
		long timeLong = datetime.getTime();
		System.out.println(timeLong);
		Assert.assertTrue(String.valueOf(timeLong).length() == 13);
	}
	

}
