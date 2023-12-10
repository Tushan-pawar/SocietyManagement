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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Bill;
import com.springboot.main.model.CourierLog;
import com.springboot.main.model.HelpDesk;
import com.springboot.main.model.Resident;
import com.springboot.main.model.User;
import com.springboot.main.service.BillService;
import com.springboot.main.service.CourierLogService;
import com.springboot.main.service.HelpDeskService;
import com.springboot.main.service.ResidentService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = {"http://localhost:3000"})

public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ResidentService residentService;

	@Autowired
	private BillService billService;

	@Autowired
	private HelpDeskService helpDeskService;

	@Autowired
	private CourierLogService courierLogService;
/* fetch one user by id*/
	@GetMapping("/getone/{id}")
	public User getOne(@PathVariable("id") int id) {
		User user = userService.getOne(id);
		return user;
	}
	@GetMapping("/getall")
	public List<User> getAll() {
	    List<User> allUsers = userService.getAll();
	    return allUsers;
	}
	@PutMapping("/editUser/{residentId}")
    public ResponseEntity<?> editUser(@PathVariable("id") int id, @RequestBody User editedUser) {
        try {
            User existingUser = userService.getOne(id);
            if (existingUser != null) {
                existingUser.setName(editedUser.getName());
                existingUser.setEmail(editedUser.getEmail());
                existingUser.setContact(editedUser.getContact());
                existingUser.setFlatNo(editedUser.getFlatNo());
                userService.insert(existingUser);
                return ResponseEntity.ok().body("User updated successfully");
            } else {
                return ResponseEntity.badRequest().body("User not found");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating user: " + e.getMessage());
        }
    }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
		User user = userService.getOne(id);
		userService.deleteUser(user);
		return ResponseEntity.ok().body("User deleted successfully");
}
		
		
		
/* add one user */
	@PostMapping("/addUser")
	public User insert(@RequestBody User user) {
		/* save user with id */
		User newUser = userService.insert(user);
		String passwordPlain = user.getPassword();
		String encodedPassword = passwordEncoder.encode(passwordPlain);
		user.setPassword(encodedPassword);
		/* set role as user */
		user.setRole("USER");
		/* create a new Resident object */
		Resident newResident = new Resident();
		newResident.setName(newUser.getName());
		/* set role as resident */
		/* role is not enabled */
		newResident.setUser(newUser);
		/* save user in table */
		residentService.insert(newResident);
		return userService.insert(user);
	}

/* get bill by resident id*/
	@GetMapping("/getall/{residentId}")
	public ResponseEntity<?> getCourierLogByResident(@PathVariable("residentId") int residentId) {
		/* Fetch resident object using given residentId */
			List<Bill> list = billService.getBillByResident(residentId);
			return ResponseEntity.ok().body(list);
	}
	

/*resident add ticket*/
	@PostMapping("/addticket/{residentId}")
	public ResponseEntity<?> postHelpDesk(@RequestBody HelpDesk helpDesk, @PathVariable("residentId") int residentId) {
		try {
			Resident resident = residentService.getOne(residentId);
			helpDesk.setResident(resident);
			helpDesk = helpDeskService.postHelpDesk(helpDesk);
			helpDesk.setStatus("ACTIVE");
			return ResponseEntity.ok().body(helpDesk);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
/* get tickets by resident id*/
	@GetMapping("/ticketsByResident/{residentId}")
	public ResponseEntity<List<HelpDesk>> getTicketsByResident(@PathVariable("residentId") int residentId) {
		List<HelpDesk> ticketsByResident = helpDeskService.getTicketsByResident(residentId);
		return ResponseEntity.ok().body(ticketsByResident);
	}
/* courier is added by resident id*/
	@PostMapping("/addcourier/{residentId}")
	public ResponseEntity<?> addCourierLogByResident(@RequestBody CourierLog courierLog,
			@PathVariable("residentId") int residentId) {
		try {
			Resident resident = residentService.getOne(residentId);
			courierLog.setResident(resident);
			courierLog = courierLogService.insert(courierLog);
			return ResponseEntity.ok().body(courierLog);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
