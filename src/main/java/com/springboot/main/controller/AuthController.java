package com.springboot.main.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.User;
import com.springboot.main.service.UserService;

@RestController
@CrossOrigin(origins = { "http://localhost:3000" })
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/user/login")
	public User Login(Principal principal) {
		String username = principal.getName();
		User user = userService.getUserByUserName(username);
		return user;
	}
}
