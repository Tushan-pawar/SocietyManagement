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
import com.springboot.main.model.Resident;
import com.springboot.main.service.BillService;
import com.springboot.main.service.ResidentService;

@Controller
@RequestMapping("/bills")
public class BillController {
	@Autowired
	private BillService billService;
	@Autowired 
	private ResidentService residentService;
	
	/*@PostMapping("/add")
	public Bill insertBill(Bill bill) {
		bill = billService.insert(bill);
		return bill;
	}*/
	@PostMapping("/add/{residentId}")
	  public ResponseEntity<?> postBill(@RequestBody Bill bill, 
              @PathVariable("residentId") int residentId){
		/*Fetch Resident object from db using residentId*/
		try {
			Resident resident =residentService.getOne(residentId);
			//Attach Resident to Bill
			bill.setResident(resident);
			//save the bill in the DB
			bill = billService.postBill(bill);

            return ResponseEntity.ok().body(bill);
        } catch (InvalidIdException e) {
            
            return ResponseEntity.badRequest().body(e.getMessage());
			
		}
	}
}