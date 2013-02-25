package com.mochasoft.example.test.data;

import com.mochasoft.example.entity.User;

/**
 * 用户测试数据生成.
 * 
 */
public class UserData {

	public static User randomUser() {
		String userName = RandomData.randomName("User");

		User user = new User();
		user.setLoginName(userName);
		user.setName(userName);
		user.setPlainPassword("123456");
		user.setEmail(userName + "@mochasoft.com.cn");
		return user;
	}
}
