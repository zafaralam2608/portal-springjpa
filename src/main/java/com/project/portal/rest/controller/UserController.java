package com.project.portal.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

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

	@GetMapping("/count")
	public long count() {
		return userService.count();
	}

	@GetMapping("/all")
	public List<UserDto> getUsers() {
		List<User> users = userService.findAllUsers();
		return convertDaosToDtos(users);
	}

	@GetMapping("/{id}")
	public UserDto getUser(@PathVariable("id") Long id) {
		User user = userService.findById(id);
		return convertDaoToDto(user);
	}

	@PostMapping("/create")
	public String createUser(@RequestBody UserDto userDto) {
		User user = convertDtoToDao(userDto);
		return userService.createUser(user);
	}

	@PostMapping("/createMultiple")
	public String createUsers(@RequestBody List<UserDto> dtos) {
		List<User> users = convertDtosToDaos(dtos);
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

	private UserDto convertDaoToDto(User dao) {
		return modelMapper.map(dao, UserDto.class);
	}

	private User convertDtoToDao(UserDto dto) {
		return modelMapper.map(dto, User.class);
	}

	private List<UserDto> convertDaosToDtos(List<User> daos) {
		return daos.stream().map(this::convertDaoToDto).collect(Collectors.toList());
	}

	private List<User> convertDtosToDaos(List<UserDto> dtos) {
		return dtos.stream().map(this::convertDtoToDao).collect(Collectors.toList());
	}
}
