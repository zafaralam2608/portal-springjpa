package com.project.portal.service;

import java.util.List;

import com.project.portal.model.User;

public interface UserService {

	List<User> findAllUsers();
	
	User findById(String id);
	
	String createUser(User user);

	String deleteById(String id);

}
