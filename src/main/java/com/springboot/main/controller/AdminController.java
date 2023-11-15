package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Admin;
import com.springboot.main.model.User;
import com.springboot.main.service.AdminService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public Admin insert(@RequestBody Admin admin) {
		try {
			if (admin.getUser() == null /* add other conditions for mandatory fields */) {
				throw new IllegalArgumentException("Please fill in all required fields.");
			}
			// Save user with id
			User user = admin.getUser();
			// Set role as Administrator
			user.setRole("ADMIN");
			// Update the Administrator object with the modified User object
			admin.setUser(user);
			// Save user object.
			user = userService.insert(user);
			// Save modified Administrator object to the database
			return adminService.insert(admin);
		} catch (Exception e) {
			// Handle the exception (e.g., log it, return an error response)
			throw new RuntimeException("ERROR" + e.getMessage());

		}
	}
}
