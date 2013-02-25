package com.mochasoft.fk.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mochasoft.fk.security.entity.RolePermission;
import com.mochasoft.fk.security.mapper.RolePermissionMapper;
import com.mochasoft.fk.security.service.IRolePermissionService;

@Service
@Transactional
public class RolePermissionServiceImpl implements IRolePermissionService {
	@Autowired
	private RolePermissionMapper mapper;

	@Override
	public void add(RolePermission entity) {
		mapper.insert(entity);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RolePermission> selectAll() {
		return mapper.selectAll();
	}

	@Override
	@Transactional(readOnly = true)
	public RolePermission selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(RolePermission entity) {
		return mapper.updateByPrimaryKey(entity);
	}

}
