package com.mochasoft.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mochasoft.example.dao.UserMybatisDao;
import com.mochasoft.example.entity.User;
import com.mochasoft.example.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMybatisDao userMybatisDao;

	@Override
	@Transactional
	public void addUser(User user) {
		System.out.println("addUser...method");
		userMybatisDao.save(user);
	}
	
//	private void exception() {
//		throw new RuntimeException("异常来一个，看看事务正常不。");
//	}

	@Override
	@Transactional
	public void updateUser(User user) {
		System.out.println("updateUser...method");
		deleteUser(user);
//		exception();  //验证事务的完整性，出现异常验证是否回滚
		addUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(User user) {
		System.out.println("deleteUser...method");
		userMybatisDao.delete(user.getId());
	}

	@Override
	@Transactional(readOnly=true)
	public User getUser(Long id) {
		System.out.println("getUsers...method");
		return userMybatisDao.get(id);
	}

}
