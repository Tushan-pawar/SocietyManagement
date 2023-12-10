package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Gatekeeper;
import com.springboot.main.model.Resident;
import com.springboot.main.model.User;
import com.springboot.main.model.VisitorLog;
import com.springboot.main.service.GatekeeperService;
import com.springboot.main.service.ResidentService;
import com.springboot.main.service.UserService;
import com.springboot.main.service.VisitorLogService;

@RestController
@RequestMapping("/gatekeeper")
@CrossOrigin(origins = { "http://localhost:3000" })

public class GatekeeperController {

	@Autowired
	private GatekeeperService gatekeeperService;
	@Autowired
	private UserService userService;
	@Autowired
	private ResidentService residentService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private VisitorLogService visitorLogService;

	@GetMapping("/getAll")
	public List<Gatekeeper> getAllGatekeeper() {
		return gatekeeperService.getAllGatekeeper();
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteGatekeeper(@PathVariable("id") int gatekeeperId) {
	    try {
	        // Get the gatekeeper
	        Gatekeeper gatekeeper = gatekeeperService.getOne(gatekeeperId);
	        // Get the associated user
	        User user = gatekeeper.getUser();
	        // Delete the gatekeeper
	        gatekeeperService.deleteGatekeeper(gatekeeper);
	        // Delete the user
	        userService.deleteUser(user);
	        return ResponseEntity.ok().body("Gatekeeper and associated user deleted successfully");
	    } catch (InvalidIdException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}


	@PostMapping("/add")
	public Gatekeeper insert(@RequestBody Gatekeeper gatekeeper) {
		/* save user with id */
		User user = gatekeeper.getUser();
		String passwordPlain = user.getPassword();
		String encodedPassword = passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
		/* set role as gatekeeper */
		user.setRole("GATEKEEPER");
		/* Update the Gatekeeper object */
		gatekeeper.setUser(user);
		/* save gatekeeper as user in table */
		user = userService.insert(user);
		/* Save the modified Gatekeeper object to the database */
		return gatekeeperService.insert(gatekeeper);
	}

	@PostMapping("/addVisitor/{gatekeeperId}/{residentId}")
	public ResponseEntity<?> addVisitorLog(@RequestBody VisitorLog visitorLog,
			@PathVariable("gatekeeperId") int gatekeeperId, @PathVariable("residentId") int residentId) {
		try {
			Gatekeeper gatekeeper = gatekeeperService.getOne(gatekeeperId);
			visitorLog.setGateKeeper(gatekeeper);
			Resident resident = residentService.getOne(residentId);
			visitorLog.setResident(resident);
			visitorLog = visitorLogService.insert(visitorLog);
			return ResponseEntity.ok().body(visitorLog);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}