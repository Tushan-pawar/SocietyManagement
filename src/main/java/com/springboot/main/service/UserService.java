<<<<<<< HEAD
package com.springboot.main.service;

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

<<<<<<< HEAD
=======
=======
package com.springboot.main.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.User;
import com.springboot.main.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	public User insert(User user) {
		return userRepository.save(user);
	}
	public User getOne(int id) throws InvalidIdException {
		Optional<User> optional =  userRepository.findById(id);
		if(!optional.isPresent()){
			throw new InvalidIdException("user ID Invalid");
		}
		return optional.get();
	}
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		 userRepository.delete(user);
	}

>>>>>>> bc1f25922778682115cb590275a680864198a72b
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
}