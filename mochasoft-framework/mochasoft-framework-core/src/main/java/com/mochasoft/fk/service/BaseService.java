package com.mochasoft.fk.service;

import java.util.List;

/**
 * <strong>Title : BaseService </strong>. <br>
 * <strong>Description : 业务层常规方法定义.</strong> <br>
 * <strong>Create on : 2013-1-22 下午3:08:35 </strong>. <br>
 * <p>
 * <strong>Copyright (C) Mocha Software Co.,Ltd.</strong> <br>
 * </p>
 * @author wanghe wanghe@mochasoft.com.cn <br>
 * @version <strong>FrameWork v0.8</strong> <br>
 * <br>
 * <strong>修改历史: .</strong> <br>
 * 修改人 修改日期 修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
public interface BaseService<Entity> {
	
	/**
	 * 添加一个Entity
	 * @param entity 实体对象
	 */
	void add(Entity entity);
	
	/**
	 * 修改一个Entity
	 */
	int update(Entity entity);
	
	/**
	 * 根据主键id删除 Entity对象.
	 * @param id 删除的行数
	 */
	int deleteByPrimaryKey(String id);
	
	/**
	 * 根据主键id查询Entity对象
	 * @param id
	 * @return
	 */
	Entity selectByPrimaryKey(String id);
	
	/**
	 * 查询所有Users对象.
	 * @return
	 */
	List<Entity> selectAll();

}
