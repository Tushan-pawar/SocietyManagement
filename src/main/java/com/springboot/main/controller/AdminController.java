package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Admin;
import com.springboot.main.model.Gatekeeper;
import com.springboot.main.model.Resident;
import com.springboot.main.model.User;
import com.springboot.main.service.AdminService;
import com.springboot.main.service.GatekeeperService;
import com.springboot.main.service.ResidentService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	@Autowired
	private ResidentService residentService;
	@Autowired
	private GatekeeperService gatekeeperService;
	
	@PostMapping("/addResident")
	public Resident insert(@RequestBody Resident resident) {
		/* save user with id */
		User user = resident.getUser();
		/* set role as resident */
		user.setRole("RESIDENT");
		/* Update the user object */
		resident.setUser(user);
		/* save resident as user in table */
		user = userService.insert(user);	
		/* Save the modified user object to the database */
		return residentService.insert(resident);
	}
	
	@PostMapping("/addGatekeeper")
	public Gatekeeper insert(@RequestBody Gatekeeper gatekeeper) {
		/* save user with id */
		User user = gatekeeper.getUser();
		/* set role as gatekeeper */
		user.setRole("GATEKEEPER");
		/* Update the Gatekeeper object */
		gatekeeper.setUser(user);
		/* save gatekeeper as user in table */
		user = userService.insert(user);
		/* Save the modified Gatekeeper object to the database */
		return gatekeeperService.insert(gatekeeper);
	}
	
	@PostMapping("/addAdmin")
	public Admin insert(@RequestBody Admin admin) {
			// Save user with id
			User user = admin.getUser();
			// Set role as Administrator
			user.setRole("ADMIN");
			// Update the Administrator object with the modified User object
			admin.setUser(user);
			// Save user object.
			user = userService.insert(user);
			// Save modified Administrator object to the database and show output 
			return adminService.insert(admin);
		}
	
}