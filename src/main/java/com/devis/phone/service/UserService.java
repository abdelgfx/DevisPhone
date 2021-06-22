package com.devis.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devis.phone.model.User;
import com.devis.phone.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void addAllUser(List<User> users) {
		for (User brand : users)
			userRepository.save(brand);
	}

	public User getUser(Long id) {
		return userRepository.findById(id).get();
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public void deleteAllusers() {
		userRepository.deleteAll();
	}

	public User updateUser(User user) {
		// TODO

		return null;
	}
}
