package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Resident;
import com.springboot.main.model.User;
import com.springboot.main.service.ResidentService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/resident")
public class ResidentController {

	@Autowired
	private ResidentService residentService;
	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public Resident insert(@RequestBody Resident resident) {
		User user = resident.getUser();
		user.setRole("RESIDENT");
		user = userService.insert(user);
		resident.setUser(user);
		return residentService.insert(resident);
	}

}
