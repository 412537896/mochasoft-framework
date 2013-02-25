package com.mochasoft.example.mapper;

import java.util.List;
import java.util.Map;

import com.mochasoft.example.entity.User;
import com.mochasoft.fk.mapper.MyBatisRepository;

/**
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 */
@MyBatisRepository
public interface UserMapper {

	User get(Long id);

	List<User> search(Map<String, Object> parameters);

	void save(User user);

	void delete(Long id);
}
