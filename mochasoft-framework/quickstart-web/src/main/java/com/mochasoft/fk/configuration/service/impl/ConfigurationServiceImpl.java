package com.mochasoft.fk.configuration.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
	@CachePut(value="ehcache", key="#entity.key")
	public String add(Configuration entity) {
		entity.setId(UUID.randomUUID().toString());
		mapper.insert(entity);
		return entity.getValue();
	}

	@Override
	@Transactional
	@CachePut(value="ehcache", key="#entity.key")
	public String update(Configuration entity) {
		mapper.updateByPrimaryKey(entity);
		return entity.getValue();
	}

	@Override
	@Transactional
	@CacheEvict(value="ehcache", key="#id")
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value="memcache", key="#id")
	public Configuration selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value="memcache", key="123")
	public List<Configuration> selectAll() {
		return mapper.selectAll();
	}

	@Override
	@CacheEvict(value = "memcache", allEntries = true)
	public void flushCacheAll() {
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value="memcache", key="#key")
	public String selectByKey(String key) {
		Configuration configuration = mapper.selectByKey(key);
		return configuration.getValue() == null
				|| configuration.getValue().equals("") ? "" : configuration
				.getValue();
	}

	@Override
	@Transactional
	@CacheEvict(value = "ehcache", key = "#key")
	public void deleteByKey(String key) {
		mapper.deleteByKey(key);
	}

}
