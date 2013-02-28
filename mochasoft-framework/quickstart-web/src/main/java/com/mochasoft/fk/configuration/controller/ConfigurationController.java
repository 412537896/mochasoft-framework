//package com.mochasoft.fk.configuration.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.mochasoft.fk.configuration.ConfigurationInfo;
//import com.mochasoft.fk.configuration.entity.Configuration;
//import com.mochasoft.fk.configuration.service.IConfigurationService;
//import com.mochasoft.fk.memcached.service.IMemConfigurationService;
//
//@Controller
//@RequestMapping("/admin/config")
//public class ConfigurationController {
//	
//	@Autowired
//	private IConfigurationService service;
//	
////	@Autowired
//	private IMemConfigurationService service2;
//	
//	@RequestMapping("/reloadAll")
//	public void reloadAll(){
//		ConfigurationInfo.getInstance().reloadAll();
//		service2.reload();
//	}
//	
//	public String addConfig(){
//		Configuration entity = new Configuration();
//		service.add(entity);
//		return null;
//	}
//}
