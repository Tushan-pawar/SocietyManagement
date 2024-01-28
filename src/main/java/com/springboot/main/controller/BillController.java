package com.springboot.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.springboot.main.model.Bill;
import com.springboot.main.model.Resident;
import com.springboot.main.service.BillService;
import com.springboot.main.service.ResidentService;

@Controller
@RequestMapping("/bills")
@CrossOrigin(origins = {"http://localhost:3000"})
public class BillController {

    @Autowired
    private ResidentService residentService;

    @Autowired
    private BillService billService;
    Logger logger = LoggerFactory.getLogger(HelpDeskController.class);

    @PostMapping("/addBills/{residentId}")
    public ResponseEntity<?> postBill(@RequestBody Bill bill, @PathVariable("residentId") int residentId) {
        try {
            Resident resident = residentService.getOne(residentId);
  		  	logger.info("Bills added ");
            bill.setResident(resident);
            bill = billService.postBill(bill);
            bill.setPaid("UNPAID");
            return ResponseEntity.ok().body(bill);
        } catch (InvalidIdException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    
    @GetMapping("/getall")
    public ResponseEntity<?> getAllBills() {
        try {
            List<Bill> allBills = billService.getAllBills();
            return ResponseEntity.ok().body(allBills);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getall/{residentId}")
    public ResponseEntity<?> getCourierLogByResident(@PathVariable("residentId") int residentId) {
        try {
            List<Bill> bills = billService.getBillByResident(residentId);
            return ResponseEntity.ok().body(bills);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("getall/unpaid")
    public ResponseEntity<?> getunPaidBill() {
        try {
            List<Bill> allUnpaidBills = billService.getUnpaidBills();
            return ResponseEntity.ok().body(allUnpaidBills);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("getall/paid")
    public ResponseEntity<?> getPaidBill() {
        try {
            List<Bill> allPaidBills = billService.getPaidBills();
            return ResponseEntity.ok().body(allPaidBills);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("getall/paid/{residentId}")
    public ResponseEntity<?> getPaidBill(@PathVariable("residentId") int residentId) {
        try {
            List<Bill> PaidBills = billService.getPaidBills();
            return ResponseEntity.ok().body(PaidBills);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
   
    @GetMapping("getall/unpaid/{residentId}")
    public ResponseEntity<?> getunPaidBill(@PathVariable("residentId") int residentId) {
        try {
            List<Bill> allUnpaidBills = billService.getUnpaidBills();
            return ResponseEntity.ok().body(allUnpaidBills);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    

}


