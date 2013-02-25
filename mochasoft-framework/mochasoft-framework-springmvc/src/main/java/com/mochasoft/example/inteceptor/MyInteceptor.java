package com.mochasoft.example.inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/*
 * 自定义拦截器
 */
public class MyInteceptor implements HandlerInterceptor {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LoggerFactory.getLogger(MyInteceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("preHandle(HttpServletRequest, HttpServletResponse, Object) - start"); //$NON-NLS-1$
		}
		if (logger.isDebugEnabled()) {
			logger.debug("preHandle(HttpServletRequest, HttpServletResponse, Object) - end"); //$NON-NLS-1$
		}
		//false中断拦截器链条，true接续拦截器链条
		return true;
	}

	//控制器已执行完毕，生成视图之前可以做动作，逆向拦截器链条，常见操作在模型中加入公共成员
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView) - start"); //$NON-NLS-1$
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("postHandle(HttpServletRequest, HttpServletResponse, Object, ModelAndView) - end"); //$NON-NLS-1$
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("afterCompletion(HttpServletRequest, HttpServletResponse, Object, Exception) - start"); //$NON-NLS-1$
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("afterCompletion(HttpServletRequest, HttpServletResponse, Object, Exception) - end"); //$NON-NLS-1$
		}
	}

}
