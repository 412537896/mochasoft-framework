package com.mochasoft.fk.configuration.servlet;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mochasoft.fk.configuration.ConfigurationInfo;
import com.mochasoft.fk.configuration.service.IConfigurationService;
import com.mochasoft.fk.configuration.service.impl.ConfigurationServiceImpl;
import com.mochasoft.fk.memcached.MemConfigurationInfo;

public class ConfigurationInitServlet extends HttpServlet {
	
	private static final Logger log = LoggerFactory.getLogger(ConfigurationInitServlet.class);
	
	private static final long serialVersionUID = -1L;
	
	private static WebApplicationContext springContext;  
    private ServletContext _servletContext;//这个是为了取servletContext
    private IConfigurationService service;
	
	public ConfigurationInitServlet() {
	}
	
	@Override
	public void init() throws ServletException {
		initSpringContext();
		
		//1.放入Map中存内存
		ConfigurationInfo.getInstance().setService(service);
		ConfigurationInfo.getInstance().reloadAll();
		
		//2.放memcacehd中
		MemConfigurationInfo memInfo = new MemConfigurationInfo(springContext);
		memInfo.putAllConfigToMemcached();
	}
	
	private void initSpringContext(){
		if(log.isInfoEnabled())
			log.info("初始化配置信息");
		_servletContext = this.getServletContext();
		springContext = WebApplicationContextUtils.getWebApplicationContext(_servletContext);
		service = springContext.getBean(ConfigurationServiceImpl.class);
	}

	
	
}
