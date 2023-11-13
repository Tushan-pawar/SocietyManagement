<<<<<<< HEAD
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
=======
package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.GateKeeper;
import com.springboot.main.model.User;
import com.springboot.main.service.GateKeeperService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/gatekeeper")
public class GateKeeperController {

	@Autowired
	private GateKeeperService gatekeeperService;
	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public GateKeeper insertGateKeeper(@RequestBody GateKeeper gatekeeper) {
		User user = gatekeeper.getUser();
		user.setRole("GATEKEEPER");
		user= userService.insert(user);
		gatekeeper.setUser(user);
		return gatekeeperService.insert(gatekeeper);
	}

}
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
