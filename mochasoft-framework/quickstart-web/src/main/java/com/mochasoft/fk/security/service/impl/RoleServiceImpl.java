package com.mochasoft.fk.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mochasoft.fk.security.entity.Role;
import com.mochasoft.fk.security.entity.RoleResource;
import com.mochasoft.fk.security.mapper.RoleMapper;
import com.mochasoft.fk.security.service.IRoleService;
import com.mochasoft.fk.utils.Identities;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleMapper mapper;

	@Override
	public void add(Role entity) {
		entity.setId(Identities.uuid());
		mapper.insert(entity);
	}

	@Override
	public int update(Role entity) {
		return mapper.updateByPrimaryKey(entity);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Role selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> selectAll() {
		return mapper.selectAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<RoleResource> selectAllRoleResource() {
		return mapper.selectAllRoleResource();
	}
}
