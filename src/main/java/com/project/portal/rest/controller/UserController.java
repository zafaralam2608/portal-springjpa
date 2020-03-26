package com.project.portal.rest.controller;

import java.util.List;

import com.project.portal.rest.dto.UserDto;
import org.modelmapper.ModelMapper;
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
public class UserController{

	@Autowired
	UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/all")
	public List<User> getUsers() {
		return userService.findAllUsers();
	}

	@GetMapping("/{id}")
	public UserDto getUser(@PathVariable("id") Long id) {
		User user = userService.findById(id);
		return convertDaoToDto(user);
	}

	@PostMapping("/create")
	public String createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PostMapping("/createMultiple")
	public String createUsers(@RequestBody List<User> users) {
		return userService.createUsers(users);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable("id") Long id) {
		return userService.deleteById(id);
	}

	@DeleteMapping("/all")
	public String deleteUsers() {
		return userService.deleteAllUsers();
	}


	protected UserDto convertDaoToDto(User dao) {
		return modelMapper.map(dao, UserDto.class);
	}


	protected User convertDtoToDao(UserDto dto) {
		return modelMapper.map(dto, User.class);
	}
}
