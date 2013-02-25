package com.mochasoft.fk.security.web.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mochasoft.fk.web.controller.BaseController;

@Controller
public class LoginLogoutController extends BaseController{
	
	/**
	 * 转发到登录页面.
	 */
	@RequestMapping(method=RequestMethod.GET,value="/login.do")
	public void home() {
	}
	
	/**
	 * 
	 * 转发到首页.
	 */
	@RequestMapping(method=RequestMethod.GET,value="/index.do")
	public void index() {
	}
	
	/**
	 * 登录错误信息提示.
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET,value="/loginError.do")
	public String loginError(Model model, HttpServletRequest request) {
		request.setAttribute("error", true);
		return "login";
	}
	
	/**
	 * 无权限处理Controller.
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value="/accessDenied.do")
	public String accessDenied(ModelMap model, HttpServletRequest request) {
		AccessDeniedException ex = (AccessDeniedException) request.getAttribute(WebAttributes.ACCESS_DENIED_403);
		StringWriter sw = new StringWriter();
		model.addAttribute("errorDetails", ex.getMessage());
		ex.printStackTrace(new PrintWriter(sw));
		model.addAttribute("errorTrace", sw.toString());
		return "commons/accessDenied";
	}
}
