package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Admin;
import com.springboot.main.service.AdminService;

@RestController

public class AdminController {
	@Autowired
	private AdminService adminService;

	@PostMapping("/admin/add")
	public Admin insertAdmin(@RequestBody Admin admin) {
		return adminService.insert(admin);
	}
}
