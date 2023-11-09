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

	/* add the admin */
	@PostMapping("/add")
	public Admin insertAdmin(@RequestBody Admin admin) {
		User user = admin.getUser();
		user.setRole("ADMIN");
		user = userService.insert(user);
		admin.setUser(user);
		return adminService.insert(admin);
	}
}
