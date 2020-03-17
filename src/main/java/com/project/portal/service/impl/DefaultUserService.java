package com.project.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.portal.model.User;
import com.project.portal.service.UserService;

@Service("userService")
public class DefaultUserService implements UserService {

	private static List<User> users;

	static {
		users = new ArrayList<>();
		users.add(new User("1","Bruce Wayne", "Batman","Bruce", "Wayne", "bruce.wayne@jla.com","30 Mar 1939"));
		users.add(new User("2", "Clark Kent", "Superman","Clark", "Kent", "clark.kent@jla.com", "18 Apr 1938"));
		users.add(new User("3", "Diana Prince", "Wonder Woman", "Diana", "Prince", "diana.prince@jla.com", "25 Oct 1940"));
	}

	public List<User> findAllUsers() {
		return users;
	}

	public User findById(String id) {
		return users.get(Integer.parseInt(id) - 1);
	}

	public String createUser(User user) {
		return  users.add(user) ? "User created" : "User creation failed";
	}
	
	public String deleteById(String id) {
		return  users.remove(findById(id)) ? "User deleted" : "User deletion failed";
	}
}
