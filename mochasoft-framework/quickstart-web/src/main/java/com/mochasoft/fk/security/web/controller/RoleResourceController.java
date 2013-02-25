package com.mochasoft.fk.security.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mochasoft.fk.web.controller.BaseController;

/**
 * <strong>Title : RoleResourceController </strong>. <br>
 * <strong>Description : 系统角色资源管理Controller.</strong> <br>
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
@RequestMapping("/admin/roleresource")
public class RoleResourceController  extends BaseController {
	
//	@Autowired
//	private IRoleResourceService service;
//	
//	@RequestMapping("add")
//	public String add(RoleResource entity) {
//		service.add(entity);
//		return "redirect:/admin/roleresource/show.do";
//    }
//	
//	@RequestMapping("/show")
//	public void show(Model model) {
//		List<RoleResource> list = service.selectAll();
//		model.addAttribute("list", list);
//    }
//	
//	@RequestMapping("/delete")
//	public String delete(RoleResource entity) {
//		service.deleteByEntity(entity);
//		return "redirect:/admin/roleresource/show.do";
//    }
//	
//	@RequestMapping("/addInput")
//	public void addInput() {
//	}
}
