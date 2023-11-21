package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.HelpDesk;
import com.springboot.main.model.Resident;
import com.springboot.main.service.HelpDeskService;
import com.springboot.main.service.ResidentService;

@Controller
@RequestMapping("/helpdesk")
public class HelpDeskController {
	@Autowired
	private ResidentService residentService;
	@Autowired
	private HelpDeskService helpDeskService;
	@Autowired

	/* Get all tickets user created */
	@GetMapping("/allTickets")
	public ResponseEntity<List<HelpDesk>> getAllTickets() {
		List<HelpDesk> allTickets = helpDeskService.getAllTickets();
		return ResponseEntity.ok().body(allTickets);
	}

	/*open new ticket */
	@PostMapping("/addticket/{residentId}")
	public ResponseEntity<?> postHelpDesk(@RequestBody
	HelpDesk helpDesk, @PathVariable("residentId") int
	residentId) {
	try {
	Resident resident = residentService.getOne(residentId);
	helpDesk.setResident(resident);
	helpDesk = helpDeskService.postHelpDesk(helpDesk);
	helpDesk.setStatus("ACTIVE");
	return ResponseEntity.ok().body(helpDesk);}
	catch (InvalidIdException e) {
	return
	ResponseEntity.badRequest().body(e.getMessage());}}
	
	/* Fetch all ticket by residentid */
	@GetMapping("/getTicket/{residentId}")
	public ResponseEntity<?> getHelpDesk(@PathVariable("residentId") int residentId) throws Exception {
	    List<HelpDesk> helpDeskList = helpDeskService.getTicketsByResident(residentId);
	    return ResponseEntity.ok().body(helpDeskList);
	}

	/* Update tickets user created */

	@PutMapping("/updateAnotherTicket/{ticketId}")
	public ResponseEntity<?> updateAnotherHelpDesk(@PathVariable("ticketId") int ticketId,
	        @RequestBody HelpDesk updatedTicket) {
	    try {
	        HelpDesk existingTicket = helpDeskService.getOne(ticketId);
	        if (updatedTicket.getName() != null) {
	            existingTicket.setName(updatedTicket.getName());
	        }
	        if (updatedTicket.getDate() != null) {
	            existingTicket.setDate(updatedTicket.getDate());
	        }
	        if (updatedTicket.getDescription() != null) {
	            existingTicket.setDescription(updatedTicket.getDescription());
	        }
	        if (updatedTicket.getStatus() != null) {
	            existingTicket.setStatus(updatedTicket.getStatus());
	        }

	        HelpDesk updatedTicketEntity = helpDeskService.postHelpDesk(existingTicket);

	        return ResponseEntity.ok().body(updatedTicketEntity);
	    } catch (InvalidIdException e) {
	        return ResponseEntity.badRequest().body(e.getMessage());
	    }
	}

	
}
