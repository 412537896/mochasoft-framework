package com.mochasoft.example.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mochasoft.example.entity.UserInfo;
import com.mochasoft.example.service.UserInfoService;

/**
 * <strong>Title : UserController </strong>. <br>
 * <strong>Description : 用户管理Controller.</strong> <br>
 * <strong>Create on : 2012-9-5 上午8:51:03 </strong>. <br>
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
@Controller
@RequestMapping("/admin/user")
public class UserController {
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	/** 
	 * <code>infoService</code> - 用户管理service层接口. 
	 */
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 添加用户.
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("User-add")
	public void add(UserInfo userInfo) throws Exception {
		userInfoService.add(userInfo);
    }
	
	/**
	 * 列举所有用户.
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/User-show")
	public void show(Model model) throws Exception {
		List<UserInfo> userList = userInfoService.list();
		if(logger.isInfoEnabled()) {
			logger.info(userList.toString());
		}
		model.addAttribute("userList", userList);
    }
	
	/**
	 * 根据id删除一个用户.
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/User-delete")
	public void delete(int id) throws Exception {
		userInfoService.deleteById(id);
    }
	
	/**
	 * 跳转到增加人员页面.
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/User-addInput")
	public void addInput() throws Exception {
	}
}
