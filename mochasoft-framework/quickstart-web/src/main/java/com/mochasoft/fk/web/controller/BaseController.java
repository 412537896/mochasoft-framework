package com.mochasoft.fk.web.controller;

import org.springframework.security.core.Authentication;

import com.mochasoft.fk.security.common.SpringSecurityUtils;
import com.mochasoft.fk.security.entity.IUserDetails;

/**
 * <strong>Title : BaseController </strong>. <br>
 * <strong>Description : Controller基类，提供一些基础服务.</strong> <br>
 * <strong>Create on : 2013-1-21 下午6:14:05 </strong>. <br>
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
public class BaseController {
	
	public BaseController() {
	}
	
	protected Authentication getAuthentication() {
		return SpringSecurityUtils.getAuthentication();
	}
	
	protected IUserDetails getUserDetails() {
		return SpringSecurityUtils.getCurrentUser();
	}

//	@ModelAttribute("showLoginLink")
//	public boolean getShowLoginLink() {
//		for (GrantedAuthority authority : getAuthentication().getAuthorities()) {
//			if(authority.getAuthority().equals("ROLE_USER")) {
//				return false;
//			}	
//		}
//		return true;
//	}
	
//
//	/**
//	 * 得到struts properties配置文件里面内容的方法
//	 * 
//	 * @param request
//	 *            HttpServletRequest
//	 * @param bundle
//	 *            配置文件的bundle
//	 * @param key
//	 *            内容的key值
//	 * @param args
//	 *            需要传递的参数
//	 * @return key值对应的value
//	 */
//	public String getMessageValue(HttpServletRequest request, String bundle,
//			String key, String args[]) {
//		MessageResources t_messageResources = getResources(request, bundle);
//		return t_messageResources.getMessage(key, args);
//	}
//
//	/**
//	 * 得到struts properties配置文件里面内容的方法
//	 * 
//	 * @param request
//	 *            HttpServletRequest
//	 * @param bundle
//	 *            配置文件的bundle
//	 * @param key
//	 *            内容的key值
//	 * @return key值对应的value
//	 */
//	public String getMessageValue(HttpServletRequest request, String bundle,
//			String key) {
//		MessageResources t_messageResources = getResources(request, bundle);
//		return t_messageResources.getMessage(key);
//	}
//
}
