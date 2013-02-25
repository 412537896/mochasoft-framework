package com.mochasoft.fk.security.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mochasoft.fk.security.entity.Resource;
import com.mochasoft.fk.security.service.IResourceService;
import com.mochasoft.fk.web.controller.BaseController;

/**
 * <strong>Title : ResourceController </strong>. <br>
 * <strong>Description : 系统资源管理Controller.</strong> <br>
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
@RequestMapping("/admin/resource")
public class ResourceController  extends BaseController {
	
	@Autowired
	private IResourceService service;
	
	/**
	 * 添加用户.
	 * @return
	 */
	@RequestMapping("add")
	public String add(Resource entity) {
		service.add(entity);
		return "redirect:/admin/resource/show.do";
    }
	
	/**
	 * 列举所有用户.
	 * @return
	 */
	@RequestMapping("/show")
	public void show(Model model) {
		List<Resource> list = service.selectAll();
		model.addAttribute("list", list);
    }
	
	/**
	 * 根据id删除一个用户.
	 * @return
	 */
	@RequestMapping("/delete")
	public String delete(String id) {
		service.deleteByPrimaryKey(id);
		return "redirect:/admin/resource/show.do";
    }
	
	/**
	 * 跳转到增加人员页面.
	 * @return
	 */
	@RequestMapping("/addInput")
	public void addInput() {
	}
	
	/**
	 * 跳转到修改页面.
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateInput(Model model, String id) {
		Resource entity = service.selectByPrimaryKey(id);
		model.addAttribute("entity", entity);
		return "admin/resource/updateInput";
	}
	
	/**
	 * 执行修改提交.
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(Resource entity) {
		service.update(entity);
		return "redirect:/admin/resource/show.do";
	}
}
