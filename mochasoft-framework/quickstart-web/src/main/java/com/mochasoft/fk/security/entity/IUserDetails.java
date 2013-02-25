package com.mochasoft.fk.security.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <strong>Title : IUserDetails </strong>. <br>
 * <strong>Description : UserDetails.</strong> <br>
 * <strong>Create on : 2013-1-30 上午9:05:01 </strong>. <br>
 * <p>
 * <strong>Copyright (C) Mocha Software Co.,Ltd.</strong> <br>
 * </p>
 * 
 * @author wanghe wanghe@mochasoft.com.cn <br>
 * @version <strong>FrameWork v0.8</strong> <br>
 * <br>
 *          <strong>修改历史: .</strong> <br>
 *          修改人 修改日期 修改描述<br>
 *          -------------------------------------------<br>
 * <br>
 * <br>
 */
public interface IUserDetails extends UserDetails {

	void setName(String name);

	String getName();

	String getUserId();

	void setPassword(String password);

	String getPassword();
	
	Collection<GrantedAuthority> getAuthorities();
}
