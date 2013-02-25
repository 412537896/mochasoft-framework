package com.mochasoft.fk.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mochasoft.fk.security.entity.RoleUser;
import com.mochasoft.fk.security.mapper.RoleUserMapper;
import com.mochasoft.fk.security.service.IRoleUserService;

@Service
@Transactional
public class RoleUserServiceImpl implements IRoleUserService{
	@Autowired
	private RoleUserMapper mapper;

	@Override
	public void add(RoleUser entity) {
		mapper.insert(entity);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RoleUser> selectAll() {
		return mapper.selectAll();
	}

	@Override
	@Transactional(readOnly = true)
	public RoleUser selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(RoleUser entity) {
		return mapper.updateByPrimaryKey(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public List<String> selectByUserId(String userId) {
		return mapper.selectByUserId(userId);
	}

	
}
