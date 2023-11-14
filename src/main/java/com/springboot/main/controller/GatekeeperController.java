package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Gatekeeper;
import com.springboot.main.model.User;
import com.springboot.main.service.GatekeeperService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/gatekeeper")
public class GatekeeperController {

	@Autowired
	private GatekeeperService gatekeeperService;
	@Autowired
	private UserService userService;

	@PostMapping("/add")
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

}
