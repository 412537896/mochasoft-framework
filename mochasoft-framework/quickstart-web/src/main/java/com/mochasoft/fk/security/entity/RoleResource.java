package com.mochasoft.fk.security.entity;

public class RoleResource {
	
	private String resources;
	private String roleName;
	
	public RoleResource(){}
	
	public String getResources() {
		return resources;
	}
	public void setResources(String resources) {
		this.resources = resources;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
