package com.mochasoft.fk.configuration.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mochasoft.fk.configuration.entity.Configuration;
import com.mochasoft.fk.configuration.mapper.ConfigurationMapper;
import com.mochasoft.fk.configuration.service.IConfigurationService;

@Service()
@Transactional
public class ConfigurationServiceImpl implements IConfigurationService {
	
	@Autowired
	private ConfigurationMapper mapper;
	
	@Override
	@Transactional
	public void add(Configuration entity) {
		mapper.insert(entity);
	}

	@Override
	@Transactional
	public int update(Configuration entity) {
		return mapper.updateByPrimaryKey(entity);
	}

	@Override
	@Transactional
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Configuration selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Configuration> selectAll() {
		return mapper.selectAll();
	}
}
