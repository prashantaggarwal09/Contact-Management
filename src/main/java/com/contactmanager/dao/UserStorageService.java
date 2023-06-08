package com.contactmanager.dao;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contactmanager.entity.User;

@Service
public class UserStorageService {

	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) throws IOException {
		System.out.println("from database before update: ");
		return userRepository.save(user);
	}

	public Optional<User> findById(Integer id) {
		if (id != null) {
			return userRepository.findById(id);
		} else
			return null;
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

}
