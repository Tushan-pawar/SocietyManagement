package com.springboot.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.User;
import com.springboot.main.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User insert(User user) {
		return userRepository.save(user);
	}
	
	
	public User loadUserByUsername(String username) {
		System.out.println("Loading done");
		User user = userRepository.findByUsername(username);
		return user;
	}


	public User getOne(int id) {
	    Optional<User> userOptional = userRepository.findById(id);
	    if (!userOptional.isPresent()) {
	        throw new RuntimeException("Not found");
	    }
	    return userOptional.get();
	}
}