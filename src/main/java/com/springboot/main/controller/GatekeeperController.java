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
	public Gatekeeper insertGateKeeper(@RequestBody Gatekeeper gatekeeper) {
		User user = gatekeeper.getUser();
		user.setRole("GATEKEEPER");
		user= userService.insert(user);
		gatekeeper.setUser(user);
		return gatekeeperService.insert(gatekeeper);
	}

}
