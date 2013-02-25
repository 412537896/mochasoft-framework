package com.mochasoft.fk.security.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mochasoft.fk.security.entity.RoleUser;
import com.mochasoft.fk.security.service.IRoleUserService;
import com.mochasoft.fk.web.controller.BaseController;

/**
 * <strong>Title : RoleUserController </strong>. <br>
 * <strong>Description : 系统角色用户管理Controller.</strong> <br>
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
@RequestMapping("/admin/roleuser")
public class RoleUserController  extends BaseController {
	
	@Autowired
	private IRoleUserService service;
	
	@RequestMapping("add")
	public String add(RoleUser entity) {
		service.add(entity);
		return "redirect:/admin/roleuser/show.do";
    }
	
	@RequestMapping("/show")
	public void show(Model model) {
		List<RoleUser> list = service.selectAll();
		model.addAttribute("list", list);
    }
	
	@RequestMapping("/delete")
	public String delete(RoleUser entity) {
		service.deleteByPrimaryKey(entity.getId());
		return "redirect:/admin/roleuser/show.do";
    }
	
	@RequestMapping("/addInput")
	public void addInput() {
	}
}
