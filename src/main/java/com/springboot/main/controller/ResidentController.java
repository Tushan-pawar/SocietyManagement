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
import com.springboot.main.model.Resident;
import com.springboot.main.model.User;
import com.springboot.main.service.ResidentService;
import com.springboot.main.service.UserService;

@RestController
@RequestMapping("/resident")
@CrossOrigin(origins = {"http://localhost:3000"})
public class ResidentController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ResidentService residentService;

    @PostMapping("/add")
    public Resident insert(@RequestBody Resident resident) {
        User user = resident.getUser();
        user.setRole("RESIDENT");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userService.insert(user);
        resident.setUser(user);
        resident = residentService.insert(resident);
        return resident;
    }

    @GetMapping("/getone/{residentId}")
    public ResponseEntity<?> getOne(@PathVariable("residentId") int residentId) {
        try {
            Resident resident = residentService.getOne(residentId);
            return ResponseEntity.ok().body(resident);
        } catch (InvalidIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

  
    @GetMapping("/getResidentIdByUserId/{userId}")
    public ResponseEntity<?> getResidentIdByUserId(@PathVariable("userId") int userId) {
        int residentId = residentService.getResidentIdByUserId(userId);
		return ResponseEntity.ok().body(residentId);
    }


    @GetMapping("/getAllResidents")
    public ResponseEntity<?> getAllResidents() {
        List<Resident> allResidents = residentService.getAllResidents();
        return ResponseEntity.ok().body(allResidents);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteResident(@PathVariable("id") int residentId) {
        try {
            // Get the resident
            Resident resident = residentService.getOne(residentId);
            // Get the associated user
            User user = resident.getUser();
            // Delete the resident
            residentService.deleteResident(resident);
            // Delete the user
            userService.deleteUser(user);

            return ResponseEntity.ok().body("Resident and associated user deleted successfully");
        } catch (InvalidIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateResident(@PathVariable("id") int residentId, @RequestBody Resident resident) {
        try {
            resident.setId(residentId);
            Resident updatedResident = residentService.updateResident(residentId, resident);
            return ResponseEntity.ok().body(updatedResident);
        } catch (InvalidIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
