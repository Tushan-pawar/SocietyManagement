
package com.springboot.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Bill;
import com.springboot.main.model.HomeService;
import com.springboot.main.model.Resident;
import com.springboot.main.service.HomeServiceService;
import com.springboot.main.service.ResidentService;

@Controller
@RequestMapping("/homeservices")
public class HomeServiceController {
	@Autowired
	private ResidentService residentService;
	@Autowired
	private HomeServiceService homeServiceService ;
	/*@PostMapping("/add")
	public HomeService insertHomeService(@RequestBody HomeService homeService) {
		homeService=homeServiceService.insert(homeService);
		return homeService;*/
	@PostMapping("/add/{residentId}")
	  public ResponseEntity<?> postHomeService(@RequestBody HomeService homeService, 
          @PathVariable("residentId") int residentId){
		/*Fetch Resident object from db using residentId*/
		try {
			Resident resident =residentService.getOne(residentId);
			//Attach Resident to HomeService
			homeService.setResident(resident);
			//save the home service in the DB
			homeService = homeServiceService.postHomeService(homeService);

        return ResponseEntity.ok().body(homeService);
    } catch (InvalidIdException e) {
        
        return ResponseEntity.badRequest().body(e.getMessage());
			
		}
	}

}

