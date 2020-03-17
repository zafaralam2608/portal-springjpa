package com.project.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.portal.model.User;
import com.project.portal.service.UserService;
import com.project.portal.repository.UserRepository;

@Service("userService")
public class DefaultUserService implements UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.getOne(id);
	}

	public String createUser(User user) {
		userRepository.saveAndFlush(user);
		return  "User created";
	}

	public String createUsers(List<User> users) {
		userRepository.saveAll(users);
		return  "Users created";
	}
	
	public String deleteById(Long id) {
		userRepository.deleteById(id);
		return "User deleted" ;
	}
}
