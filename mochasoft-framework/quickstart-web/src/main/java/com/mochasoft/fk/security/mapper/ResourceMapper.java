package com.mochasoft.fk.security.mapper;

import com.mochasoft.fk.mapper.MyBatisRepository;
import com.mochasoft.fk.security.entity.Resource;
import java.util.List;

@MyBatisRepository
public interface ResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOCHA_SECU_RESOURCE
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOCHA_SECU_RESOURCE
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    int insert(Resource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOCHA_SECU_RESOURCE
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    Resource selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOCHA_SECU_RESOURCE
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    List<Resource> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table MOCHA_SECU_RESOURCE
     *
     * @mbggenerated Wed Feb 20 16:25:27 CST 2013
     */
    int updateByPrimaryKey(Resource record);
}