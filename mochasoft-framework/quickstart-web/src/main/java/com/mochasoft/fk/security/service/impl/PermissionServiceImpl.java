package com.mochasoft.fk.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mochasoft.fk.security.entity.Permission;
import com.mochasoft.fk.security.mapper.PermissionMapper;
import com.mochasoft.fk.security.service.IPermissionService;

@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
	@Autowired
	private PermissionMapper mapper;

	@Override
	public void add(Permission entity) {
		mapper.insert(entity);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Permission> selectAll() {
		return mapper.selectAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Permission selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(Permission entity) {
		return mapper.updateByPrimaryKey(entity);
	}

}
