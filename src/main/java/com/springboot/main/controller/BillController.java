<<<<<<< HEAD
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
=======
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.main.model.Bill;
import com.springboot.main.service.BillService;

@Controller
@RequestMapping("/bills")
public class BillController {
	@Autowired
	private BillService billService;

	@PostMapping("/add")
	public Bill insertBill(Bill bill) {
		bill = billService.insert(bill);
		return bill;
	}
<<<<<<< HEAD
<<<<<<< HEAD
}
=======
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
}
=======
package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.main.model.Bill;
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147
import com.springboot.main.service.BillService;
import com.springboot.main.service.ResidentService;

@Controller
@RequestMapping("/bills")
public class BillController {
	@Autowired
<<<<<<< HEAD
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
=======
	private ResidentService residentService;
	@Autowired 
	private BillService billService;
@PostMapping("/add")
public Bill insertBill(Bill bill) {
	bill = billService.insert(bill);
	return bill;
}
}
>>>>>>> bc1f25922778682115cb590275a680864198a72b
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147
