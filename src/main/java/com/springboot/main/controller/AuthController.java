package com.springboot.main.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.User;
import com.springboot.main.service.UserService;

@RestController
public class AuthController {

	private final UserService userService;

	@Autowired
	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/user/login")
	public User login(Principal principal) {
		if (principal != null) {
			String username = principal.getName();
			User user = (User) userService.loadUserByUsername(username);
			return user;
		} else {
			return null;
		}
	}
}