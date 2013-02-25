package com.mochasoft.fk.security.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mochasoft.fk.exception.MochaException;
import com.mochasoft.fk.security.entity.IUserDetails;
import com.mochasoft.fk.security.service.IUserService;
import com.mochasoft.fk.web.controller.BaseController;

@Controller
@RequestMapping("/user")
public class AccountController extends BaseController {
	@Autowired
	private IUserService service;
	
	@RequestMapping("/home.do")
	public void accountHome() {		
	}
	@RequestMapping(value="/changePassword.do",method=RequestMethod.GET)
	public void showChangePasswordPage() {		
	}
	@RequestMapping(value="/changePassword.do",method=RequestMethod.POST)
	public String submitChangePasswordPage(@RequestParam("password") String newPassword,
											@RequestParam("oldpassword") String oldpassword) {
		IUserDetails details = getUserDetails();
		String username = details.getUsername();
		String password = details.getPassword();
		if(service.encodePassword(oldpassword).equals(password)) {
			getUserDetails().setPassword(service.encodePassword(newPassword));
			service.changePassword(username, newPassword);
		} else {
			throw new MochaException("原密码错误。");
		}
		return "user/success";
	}
}
