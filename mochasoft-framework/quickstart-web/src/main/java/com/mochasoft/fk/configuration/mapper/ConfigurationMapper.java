package com.mochasoft.fk.configuration.mapper;

import java.util.List;

import com.mochasoft.fk.configuration.entity.Configuration;
import com.mochasoft.fk.mapper.MyBatisRepository;

@MyBatisRepository
public interface ConfigurationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOCHA_SECU_CONFIGURATION
     *
     * @mbggenerated Tue Jan 29 17:16:49 CST 2013
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOCHA_SECU_CONFIGURATION
     *
     * @mbggenerated Tue Jan 29 17:16:49 CST 2013
     */
    int insert(Configuration record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOCHA_SECU_CONFIGURATION
     *
     * @mbggenerated Tue Jan 29 17:16:49 CST 2013
     */
    Configuration selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOCHA_SECU_CONFIGURATION
     *
     * @mbggenerated Tue Jan 29 17:16:49 CST 2013
     */
    List<Configuration> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOCHA_SECU_CONFIGURATION
     *
     * @mbggenerated Tue Jan 29 17:16:49 CST 2013
     */
    int updateByPrimaryKey(Configuration record);
}