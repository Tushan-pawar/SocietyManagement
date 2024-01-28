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
import com.springboot.main.model.Admin;
import com.springboot.main.model.User;
import com.springboot.main.service.AdminService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = { "http://localhost:3000" })
public class AdminController {

	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/add")
	public Admin insert(@RequestBody Admin admin) {
		// Save user with id
		User user = admin.getUser();
		String passwordPlain = user.getPassword();
		String encodedPassword = passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
		// Set role as Administrator
		// Update the Administrator object with the modified User object
		admin.setUser(user);
		user.setRole("ADMINISTRATOR");
		// Save user object.
		user = userService.insert(user);
		// Save modified Administrator object to the database and show output
		return adminService.insert(admin);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteAdmin(@PathVariable("id") int adminId) {
	    try {
	        // Get the administrator
	        Admin admin = adminService.getOne(adminId);
	        // Get the associated user
	        User user = admin.getUser();
	        // Delete the administrator
	        adminService.deleteAdmin(admin);
	        // Delete the user
	        userService.deleteUser(user);
	        return ResponseEntity.ok().body("Administrator and associated user deleted successfully");
	    } catch (InvalidIdException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}

	
	@GetMapping("/getAll")
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}
	

}