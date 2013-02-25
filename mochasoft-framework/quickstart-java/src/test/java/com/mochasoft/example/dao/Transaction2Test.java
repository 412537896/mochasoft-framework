package com.mochasoft.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mochasoft.example.entity.User;
import com.mochasoft.example.test.data.UserData;

public class Transaction2Test {
	
	public static void main(String[] args) {
		Transaction2Test daoTest = new Transaction2Test();
		daoTest.userDaoTest();
	}
	
	public void userDaoTest() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/applicationContext.xml", "/applicationContext-fk.xml");
		UserMybatisService service = ctx.getBean(UserMybatisService.class);
		System.out.println(service);
		try {
			service.addUser();
		}catch(Throwable able) {
			able.printStackTrace();
		}
		ctx.close();
	}
	
	/*
	 * 测试事物service类
	 */
	@Service
	public static class UserMybatisService {
		@Autowired
		private UserMybatisDao userDao = null;
		
		@Transactional
		public void addUser() {
			User user = UserData.randomUser();
			userDao.save(user);
			System.out.println("1条数据已存储");
			
			User user1 = UserData.randomUser();
			userDao.save(user1);
			System.out.println("2条数据已存储");
			//验证异常是否回滚
//			throw new RuntimeException("Error!!");
		}

	}
}
