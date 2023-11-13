package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.exception.InvalidIdException;
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
	/* srikanya code */
	@GetMapping("/getall")

	public List<Resident> getAllResidents(){
	List<Resident> resident = residentService.getAllResidents();
	return resident;

	}

@GetMapping("/getone/{id}")
public ResponseEntity<?> getOne(@PathVariable("id") int id) {

	try {
		Resident resident = residentService.getOne(id);
		return ResponseEntity.ok().body(resident);
	} catch (InvalidIdException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

}

@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteVendor(@PathVariable("id") int id) {

	try {
		//validate id
		Resident resident = residentService.getOne(id);
		//delete
		residentService.deleteResident(resident);
		return ResponseEntity.ok().body("resident deleted successfully");

	} catch (InvalidIdException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
}

}
	
