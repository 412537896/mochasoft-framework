package com.mochasoft.example.service;

import com.mochasoft.example.entity.User;

public interface UserService {
	
	void addUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);
	
	User getUser(Long id);

}
