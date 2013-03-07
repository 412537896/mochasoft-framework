package com.mochasoft.fk.configuration.servlet;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mochasoft.fk.configuration.EhcacheConfigurationInfo;
import com.mochasoft.fk.configuration.MemConfigurationInfo;

public class ConfigurationInitServlet extends HttpServlet {
	
	private static final Logger log = LoggerFactory.getLogger(ConfigurationInitServlet.class);
	
	private static final long serialVersionUID = -1L;
	
	private static WebApplicationContext springContext;  
    private ServletContext _servletContext;//这个是为了取servletContext
    
    private String cacheName;
	
	public ConfigurationInitServlet() {
	}
	
	@Override
	public void init() throws ServletException {
		if(log.isInfoEnabled())
			log.info("初始化配置信息");
		initSpringContext();
		cacheName = this.getInitParameter("cacheName");
		
		if(cacheName != null){
			if(cacheName.equals("memcached")){
				//放memcacehd中
				MemConfigurationInfo memInfo = new MemConfigurationInfo(springContext);
				memInfo.putAllConfigToMemcached();
				
			} else {
				EhcacheConfigurationInfo ehcacheInfo = new EhcacheConfigurationInfo(springContext);
				ehcacheInfo.putAllConfigToMemcached();
			}
		} else {
			//默认放到ehcache
			EhcacheConfigurationInfo ehcacheInfo = new EhcacheConfigurationInfo(springContext);
			ehcacheInfo.putAllConfigToMemcached();
		}
		
	}
	
	private void initSpringContext(){
		_servletContext = this.getServletContext();
		springContext = WebApplicationContextUtils.getWebApplicationContext(_servletContext);
	}

}
