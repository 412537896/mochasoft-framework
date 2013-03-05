package com.mochasoft.fk.configuration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mochasoft.fk.configuration.service.IConfigurationService;

@Controller
@RequestMapping("/admin/config")
public class ConfigurationController {
	
	@Autowired
	private IConfigurationService service;
	
	
	@RequestMapping("/reloadAll")
	public void reloadAll(){
		service.flushCacheAll();
	}
	
	@RequestMapping("/selectAll")
	public String selectAllConfig(){
		service.selectAll();
		service.selectByKey("key1");
		service.selectByPrimaryKey("bb2749b0-5f89-48e0-a3a3-7c23da045452");
		return "index";
	}
}
