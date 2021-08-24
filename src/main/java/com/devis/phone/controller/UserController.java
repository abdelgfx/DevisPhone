package com.devis.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.model.User;
import com.devis.phone.service.UserService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")

public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return userService.getUser(id);
	}

	@PostMapping("/users")
	public void setAllUsers(@RequestBody List<User> users) {
		userService.addAllUser(users);
	}

	@PostMapping("/user")
	public void setUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@PutMapping("/users/{id}")
	public void editUser(@PathVariable("id") Long id, @RequestBody User user) {
		user.setIdUser(id);
		userService.addUser(user);
	}

}
