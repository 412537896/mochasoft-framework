package com.mochasoft.example.mapper;


import com.mochasoft.example.entity.Team;
import com.mochasoft.fk.mapper.MyBatisRepository;

/**
 * 通过@MapperScannerConfigurer扫描目录中的所有接口, 动态在Spring Context中生成实现.
 * 方法名称必须与Mapper.xml中保持一致.
 * 
 */
@MyBatisRepository
public interface TeamMapper {

	Team getWithDetail(Long id);
}