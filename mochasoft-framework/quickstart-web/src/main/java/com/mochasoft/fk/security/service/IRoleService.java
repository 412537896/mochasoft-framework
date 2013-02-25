package com.mochasoft.fk.security.service;

import java.util.List;

import com.mochasoft.fk.security.entity.Role;
import com.mochasoft.fk.security.entity.RoleResource;
import com.mochasoft.fk.service.BaseService;

public interface IRoleService extends BaseService<Role> {
	
	/**
     * 获取Role和Resource的对应关系.
     * @return Role和Resource的对应关系
     */
	List<RoleResource> selectAllRoleResource();

}
