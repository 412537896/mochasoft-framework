package com.mochasoft.fk.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mochasoft.fk.security.entity.Resource;
import com.mochasoft.fk.security.mapper.ResourceMapper;
import com.mochasoft.fk.security.service.IResourceService;
import com.mochasoft.fk.utils.Identities;

@Service
@Transactional
public class ResourceServiceImpl implements IResourceService{
	@Autowired
	private ResourceMapper mapper;

	@Override
	public void add(Resource entity) {
		entity.setId(Identities.uuid());
		mapper.insert(entity);
	}

	@Override
	public int update(Resource entity) {
		return mapper.updateByPrimaryKey(entity);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Resource selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Resource> selectAll() {
		return mapper.selectAll();
	}

}
