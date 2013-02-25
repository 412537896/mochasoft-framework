package com.mochasoft.example.service;

import java.util.List;

import com.mochasoft.example.entity.UserInfo;
import com.mochasoft.fk.db.page.Page;
import com.mochasoft.fk.exception.MochaException;

/**
 * <strong>Title : UserInfoService </strong>. <br>
 * <strong>Description : 用户信息操作的service接口.</strong> <br>
 * <strong>Create on : 2012-9-4 上午11:20:47 </strong>. <br>
 * <p>
 * <strong>Copyright (C) Mocha Software Co.,Ltd.</strong> <br>
 * </p>
 * @author wanghe wanghe@mochasoft.com.cn <br>
 * @version <strong>Framework0.0.1</strong> <br>
 * <br>
 * <strong>修改历史: .</strong> <br>
 * 修改人 修改日期 修改描述<br>
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
public interface UserInfoService {
	
	/**
	 * 添加一个用户.
	 * @param userInfo 用户信息
	 * @throws MochaException
	 */
	public void add(UserInfo userInfo) throws MochaException;
	
	/**
	 * 显示系统所有用户.
	 * @throws MochaException
	 */
	public List<UserInfo> list() throws MochaException;
	
	/**
	 * 显示系统所有用户 (分页).
	 * @throws MochaException
	 */
	public List<UserInfo> list(Page Page) throws MochaException;
	
	/**
	 * 根据用户id删除用户.
	 * @param id
	 * @throws MochaException
	 */
	public void deleteById(int id) throws MochaException;

}
