package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Resident;
import com.springboot.main.service.ResidentService;

@RestController
public class ResidentController {
	@Autowired
	private ResidentService residentService;

	@PostMapping("/resident/add")
	public Resident insertResident(@RequestBody Resident resident) {
		return residentService.insert(resident);
	}

}
