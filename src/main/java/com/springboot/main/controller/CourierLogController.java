package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.CourierLog;
import com.springboot.main.model.Gatekeeper;
import com.springboot.main.model.Resident;
import com.springboot.main.model.VisitorLog;
import com.springboot.main.service.CourierLogService;
import com.springboot.main.service.GatekeeperService;
import com.springboot.main.service.ResidentService;

@Controller
@RequestMapping("/courierlogs")
public class CourierLogController {

	@Autowired
	private CourierLogService courierLogService;
	@Autowired
	private GatekeeperService gatekeeperService;
	@Autowired
	private ResidentService residentService;

/*	@PostMapping("/add")
	public CourierLog insertCourierLog(@RequestBody CourierLog courierLog) {
		courierLog = courierLogService.insert(courierLog);
		return courierLog;
	}*/
	
	@PostMapping("/add/{gatekeeperId}/{residentId}")
	public ResponseEntity<?> addCourierLog(@RequestBody CourierLog courierLog,
            @PathVariable("gatekeeperId") int gatekeeperId,
            @PathVariable("residentId") int residentId)  {
		try{
			 // Fetch gatekeeper and resident objects from the database using IDs
            Gatekeeper gatekeeper = gatekeeperService.getOne(gatekeeperId);
            courierLog.setGateKeeper(gatekeeper);
            Resident resident = residentService.getOne(residentId);
            courierLog.setResident(resident);
            courierLog=courierLogService.insert(courierLog);
	    return ResponseEntity.ok().body(courierLog);
	}catch(InvalidIdException e) {
       
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
}