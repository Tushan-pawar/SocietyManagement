
package com.springboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	@PostMapping("/addticket/{residentId}")
	public ResponseEntity<?> postHelpDesk(@RequestBody HelpDesk helpDesk, @PathVariable("residentId") int residentId) {
		/* Fetch Resident object from db using residentId */
		try {
			Resident resident = residentService.getOne(residentId);
			// Attach Resident to Helpdesk
			helpDesk.setResident(resident);
			// save the helpdesk in the DB
			helpDesk = helpDeskService.postHelpDesk(helpDesk);
			helpDesk.setStatus("ACTIVE");
			return ResponseEntity.ok().body(helpDesk);
		} catch (InvalidIdException e) {

			return ResponseEntity.badRequest().body(e.getMessage());

		}
	}
	
}
