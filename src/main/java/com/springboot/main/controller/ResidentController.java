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
		/* Set the role of the user to resident */
		user.setRole("RESIDENT");
		/* Save theUser to the database*/
		user = userService.insert(user);
		/* Update the Resident */
		resident.setUser(user);
		/* Save the modified Resident*/
		return residentService.insert(resident);
	}

}
