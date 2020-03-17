package com.project.portal.service;

import java.util.List;

import com.project.portal.model.User;

public interface UserService {

	List<User> findAllUsers();
	
	User findById(Long id);
	
	String createUser(User user);

	String deleteById(Long id);

	String createUsers(List<User> users);
}
