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
		/* save user with id */
		User user = admin.getUser();
		/*set role as admin*/
		user.setRole("ADMIN");
		admin.setUser(user);
		/* save admin as user in table */
		user = userService.insert(user);
		return adminService.insert(admin);
	}

}
