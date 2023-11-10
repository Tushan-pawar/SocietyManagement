package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.CourierLog;
import com.springboot.main.service.CourierService;
import com.springboot.main.service.GatekeeperService;

@RestController
@RequestMapping("/courier")
public class CourierController {

	@Autowired
	private CourierService courierService;

	@PostMapping("/add")
	public CourierLog insert(@RequestBody CourierLog courierLog) {
		return courierService.insert(courierLog);
	}

}
