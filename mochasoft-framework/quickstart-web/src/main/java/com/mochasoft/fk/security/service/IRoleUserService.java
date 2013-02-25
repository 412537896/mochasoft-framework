package com.mochasoft.fk.security.service;

import java.util.List;

import com.mochasoft.fk.security.entity.RoleUser;
import com.mochasoft.fk.service.BaseService;

public interface IRoleUserService extends BaseService<RoleUser> {
	/**
	 * 根据userId查询所有用户所有的角色名称列表.
	 * @return
	 */
	List<String> selectByUserId(String userId);
}
