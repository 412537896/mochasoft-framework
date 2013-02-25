package com.mochasoft.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mochasoft.example.entity.UserInfo;
import com.mochasoft.example.mapper.UserInfoMapper;
import com.mochasoft.example.service.UserInfoService;
import com.mochasoft.fk.exception.MochaException;

/**
 * <strong>Create on : 2012-9-4 上午11:27:13 </strong>. <br>
 * <p>
 * <strong>Copyright (C) Mocha Software Co.,Ltd.</strong> <br>
 * </p>
 * 
 * @author wanghe wanghe@mochasoft.com.cn <br>
 * @version <strong>Framework0.0.1</strong> <br>
 * <br>
 *          <strong>修改历史: .</strong> <br>
 *          修改人 修改日期 修改描述<br>
 *          -------------------------------------------<br>
 * <br>
 * <br>
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;

	@Transactional
	public void add(UserInfo userInfo) throws MochaException {
		userInfoMapper.insert(userInfo);
	}

	@Transactional(readOnly=true)
	public List<UserInfo> list() throws MochaException {
		return userInfoMapper.selectAll();
	}

	@Transactional
	public void deleteById(int id) throws MochaException {
		userInfoMapper.deleteByPrimaryKey(id);
	}
}
