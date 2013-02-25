package com.mochasoft.fk.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mochasoft.fk.exception.MochaException;
import com.mochasoft.fk.security.entity.User;
import com.mochasoft.fk.security.mapper.UserMapper;
import com.mochasoft.fk.security.service.IUserService;
import com.mochasoft.fk.utils.Identities;


@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void changePassword(String userid, String password) {
		User user = new User();
		user.setPassword(password);
		user.setUserId(userid);
		user.setPassword(encodePassword(user.getPassword()));
		userMapper.changePassword(user);
	}

	@Override
	public void add(User user) {
		if(findByUserid(user.getUserId()) != null) {
			throw new MochaException(user.getUserId() +"已存在，无法创建！");
		}
		user.setId(Identities.uuid());
		user.setPassword(encodePassword(user.getPassword()));
		userMapper.insert(user);
	}

	/**
	 * 密码编码.
	 * @param User
	 */
	public String encodePassword(String password) {
		return passwordEncoder.encodePassword(password, null);
	}

	@Override
	public int update(User user) {
		user.setPassword(encodePassword(user.getPassword()));
		return userMapper.updateByPrimaryKey(user);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly=true)
	public User selectByPrimaryKey(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> selectAll() {
		return userMapper.selectAll();
	}

	@Override
	@Transactional(readOnly=true)
	public User findByUserid(String userid) {
		return userMapper.selectByUserid(userid);
	}
}
