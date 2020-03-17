package com.project.portal.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.portal.model.User;
import com.project.portal.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/all")
	public List<User> getUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return userService.findById(id);
	}

	@PostMapping("/create")
	public String createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PostMapping("/create")
	public String createUsers(@RequestBody List<User> users) {
		return userService.createUsers(users);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		return userService.deleteById(id);
	}
}
