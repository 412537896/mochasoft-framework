package com.mochasoft.fk.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mochasoft.fk.security.entity.PermissionResource;
import com.mochasoft.fk.security.mapper.PermissionResourceMapper;
import com.mochasoft.fk.security.service.IPermissionResourceService;

@Service
@Transactional
public class PermissionResourceServiceImpl implements IPermissionResourceService {
	@Autowired
	private PermissionResourceMapper mapper;

	@Override
	public void add(PermissionResource entity) {
		mapper.insert(entity);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PermissionResource> selectAll() {
		return mapper.selectAll();
	}

	@Override
	@Transactional(readOnly = true)
	public PermissionResource selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int update(PermissionResource entity) {
		return mapper.updateByPrimaryKey(entity);
	}

}
