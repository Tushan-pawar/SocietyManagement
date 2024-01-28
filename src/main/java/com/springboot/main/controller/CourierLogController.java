package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.CourierLog;
import com.springboot.main.model.Gatekeeper;
import com.springboot.main.model.Resident;
import com.springboot.main.service.CourierLogService;
import com.springboot.main.service.GatekeeperService;
import com.springboot.main.service.ResidentService;

@Controller
@RequestMapping("/courierlogs")
@CrossOrigin(origins = { "http://localhost:3000" })

public class CourierLogController {

	@Autowired
	private CourierLogService courierLogService;
	@Autowired
	private GatekeeperService gatekeeperService;
	@Autowired
	private ResidentService residentService;

	/* gatekeeper add courier for resident id */
	@PostMapping("/addcourier/{gatekeeperId}/{residentId}")
	public CourierLog addCourierLog(@RequestBody CourierLog courierLog, @PathVariable("gatekeeperId") int gatekeeperId,
			@PathVariable("residentId") int residentId) {
		try {
			Gatekeeper gatekeeper = gatekeeperService.getOne(gatekeeperId);
			courierLog.setGateKeeper(gatekeeper);

			Resident resident = residentService.getOne(residentId);
			courierLog.setResident(resident);
			return courierLogService.insert(courierLog);
		} catch (InvalidIdException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/* add courier by resident id */
	@PostMapping("/addcourier/{residentId}")
	public ResponseEntity<?> addCourierLogByResident(@RequestBody CourierLog courierLog,
			@PathVariable("residentId") int residentId) {
		try {
			/* Fetch resident object from the database using ID */
			Resident resident = residentService.getOne(residentId);
			courierLog.setResident(resident);
			courierLog = courierLogService.insert(courierLog);
			return ResponseEntity.ok().body(courierLog);
		} catch (InvalidIdException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	/* get courier by resident id */
	@GetMapping("/getcourier/{newResidentId}")
	public ResponseEntity<?> getCourierLogByResident(@PathVariable("newResidentId") int residentId) throws Exception {
		List<CourierLog> list = courierLogService.getCourierLogByResident(residentId);
		return ResponseEntity.ok().body(list);
	}
	@GetMapping("/getall")
	public ResponseEntity<?> getAllCourierLogs() {
	    List<CourierLog> courierLogs = courierLogService.getAllCourierLogs();
	    return ResponseEntity.ok().body(courierLogs);
	}
	
	}


