package com.devis.phone.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devis.phone.model.User;
import com.devis.phone.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;

	public void addBrand(User user) {
		userRepository.save(user);
	}

	public void addAllUser(List<User> users) {
		for (User brand : users)
			userRepository.save(brand);
	}

	public User getBrand(Long id) {
		return userRepository.getById(id);
	}

	public List<User> getAllBrands() {
		return userRepository.findAll();
	}

	public void deleteuser(Long id) {
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
