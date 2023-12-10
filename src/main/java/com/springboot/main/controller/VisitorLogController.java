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
import com.springboot.main.model.Gatekeeper;
import com.springboot.main.model.Resident;
import com.springboot.main.model.VisitorLog;
import com.springboot.main.service.GatekeeperService;
import com.springboot.main.service.ResidentService;
import com.springboot.main.service.VisitorLogService;

@Controller
@RequestMapping("/visitorlogs")
@CrossOrigin(origins = {"http://localhost:3000"})

public class VisitorLogController {
	@Autowired
	private VisitorLogService visitorLogService;
	@Autowired
	private GatekeeperService gatekeeperService;
	@Autowired
	private ResidentService residentService;

	@PostMapping("/add/{gatekeeperId}/{residentId}")
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
	@GetMapping("/getbyresident/{residentId}")
    public ResponseEntity<?> getVisitorLogsByResident(@PathVariable("residentId") int residentId) {
       try {
            List<VisitorLog> visitorLogs = visitorLogService.getVisitorLogsByResidentId(residentId);
            return ResponseEntity.ok().body(visitorLogs);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	@GetMapping("/getall")
	public ResponseEntity<?> getAllVisitorLogs() {
	    try {
	        List<VisitorLog> visitorLogs = visitorLogService.getAllVisitorLogs();
	        return ResponseEntity.ok().body(visitorLogs);
	    } catch (Exception e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}
}
