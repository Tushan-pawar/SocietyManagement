<<<<<<< HEAD
=======
<<<<<<< HEAD
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
}
=======
}
=======
package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.main.model.Bill;
import com.springboot.main.service.BillService;
import com.springboot.main.service.ResidentService;

@Controller
@RequestMapping("/bills")
public class BillController {
	@Autowired
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
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
