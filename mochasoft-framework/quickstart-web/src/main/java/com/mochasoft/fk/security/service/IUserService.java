package com.mochasoft.fk.security.service;

import com.mochasoft.fk.security.entity.User;
import com.mochasoft.fk.service.BaseService;

public interface IUserService extends BaseService<User> {
	
	/**
     * 根据userid查询Users对象.
     * @param userid
     * @return
     */
    User findByUserid(String userid);
	
	/**
	 * 根据userid修改用户密码.
	 * @param userid
	 * @param password
	 */
	void changePassword(String userid, String password);
	
	/**
	 * 对用户密码进行编码.
	 * @param password
	 * @return
	 */
	String encodePassword(String password);

}
