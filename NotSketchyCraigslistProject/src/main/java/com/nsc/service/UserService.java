package com.nsc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsc.entity.Post;
import com.nsc.entity.User;
import com.nsc.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public User login(String username, String password) {
		return userRepository.login(username, password);
	}

	public User getUserById(int userId) {
		return userRepository.getUserById(userId);
	}

	
	
	
	
	
	
	
}
