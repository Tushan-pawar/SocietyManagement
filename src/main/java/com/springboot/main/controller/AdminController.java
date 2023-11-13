<<<<<<< HEAD
package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
		/*Update the Admin object with the modified User object*/
		admin.setUser(user);
		/* save user object */
		user = userService.insert(user);
		/*save modified admin object to database*/
		return adminService.insert(admin);
	}
	
	/* SriKanya code*/
	@GetMapping("/getall")

	public List<Admin> getAllAdmins(){
	List<Admin> admin = adminService.getAllAdmins();
	return admin;

	}
	@GetMapping("/getone/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") int id) {

		try {
			Admin admin = adminService.getOne(id);
			return ResponseEntity.ok().body(admin);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

}

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
package com.springboot.main.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class AdminController {
	@Autowired
	private AdminService adminService;

	//@PostMapping("/admin/add")
	@Autowired
	private UserService userService;

	/* add the admin */
	@PostMapping("/add")
	public Admin insertAdmin(@RequestBody Admin admin) {
		User user = admin.getUser();
		user.setRole("ADMIN");
		user = userService.insert(user);
		admin.setUser(user);
		return adminService.insert(admin);
	}
	@GetMapping("/getall")
	
	public List<Admin> getAllAdmins(){
	List<Admin> admin = adminService.getAllAdmins();
	return admin;
		
	}
	@GetMapping("/getone/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") int id) {

		try {
			Admin admin = adminService.getOne(id);
			return ResponseEntity.ok().body(admin);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	
}
>>>>>>> bc1f25922778682115cb590275a680864198a72b
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
