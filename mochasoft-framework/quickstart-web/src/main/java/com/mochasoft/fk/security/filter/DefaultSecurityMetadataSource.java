package com.mochasoft.fk.security.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.mochasoft.fk.security.entity.RoleResource;
import com.mochasoft.fk.security.service.IRoleService;



//1 加载资源与权限的对应关系
public class DefaultSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultAccessDecisionManager.class);
	private IRoleService service;
	private Map<String, Collection<ConfigAttribute>> resourceMap = null;
	
	//由spring调用
	public DefaultSecurityMetadataSource(IRoleService service) {
		this.service = service;
		loadResourceDefine();
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}
	//加载所有资源与权限的关系
	private void loadResourceDefine() {
		resourceMap = new LinkedHashMap<String, Collection<ConfigAttribute>>();
		List<RoleResource> resources = service.selectAllRoleResource();
		for (RoleResource rr : resources) {
			/*
			 * 判断资源和权限的对应关系，如果已经存在相关的资源url，
			 * 则要通过该url为key提取出权限集合，将权限增加到权限集合中。
			 */
			if (resourceMap.containsKey(rr.getResources())) {
				continue;
			} else {
				//url模糊匹配，对/admin/*有权限的角色，对/admin/user一定有权限，反之无权限
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				for (RoleResource t_rr : resources) {
					if (matches(rr.getResources(), t_rr.getResources())) {
				        configAttributes.add(new SecurityConfig(t_rr.getRoleName()));
				    }
				}
				resourceMap.put(rr.getResources(), configAttributes);
			}
		}
	}
	//返回所请求资源所需要的权限
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		String url = requestUrl.toLowerCase();
		if(logger.isDebugEnabled()) {
			logger.debug("requestUrl is " + url);
		}
		if(resourceMap == null) {
			loadResourceDefine();
		}
		Iterator<Entry<String, Collection<ConfigAttribute>>> iterator = resourceMap.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, Collection<ConfigAttribute>> entry = iterator.next();
			String resourceUrl = entry.getKey();
			if(matches(url, resourceUrl)) {
				return entry.getValue();
			}
		}
		return null;
	}
	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}
	
	/**
	 * //第一个url为/admin/user,  第二个为/admin/*，则匹配，
	 * 		拥有通配符权限的人 可以看 第一个URL 的路径
	 * @param url
	 * @param pattern
	 * @return
	 */
	private  boolean matches(String url, String pattern) {
		PathMatcher matcher = new AntPathMatcher();
		return matcher.matchStart(pattern, url);
	}

}
