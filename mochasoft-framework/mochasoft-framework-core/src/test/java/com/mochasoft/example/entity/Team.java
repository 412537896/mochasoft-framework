package com.mochasoft.example.entity;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 开发团队.
 * 
 */
public class Team {
	private Long id;
	private String name;
	private User master;
	private List<User> userList = Lists.newArrayList();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getMaster() {
		return master;
	}

	public void setMaster(User master) {
		this.master = master;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
