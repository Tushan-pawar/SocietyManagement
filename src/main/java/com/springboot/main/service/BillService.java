	
package com.springboot.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.Bill;
import com.springboot.main.repository.BillRepository;

@Service
public class BillService {
	@Autowired
	private BillRepository billRepository;

	public Bill postBill(Bill bill) {
		return billRepository.save(bill);
	}
	  public List<Bill> getAllBills() {
	        return billRepository.findAll();
	    
}
	public List<Bill> getBillByResident(int residentId) {
		return billRepository.findByResidentId(residentId);
	}
	public List<Bill> getUnpaidBills() {
		return billRepository.getUnpaidBills();
	}
	public List<Bill> getPaidBills() {
		// TODO Auto-generated method stub
		return billRepository.getPaidBills();
	}
	
	public List<Bill> getWaterBill() {
		// TODO Auto-generated method stub
		return billRepository.getWaterBill();
	}
	
	}
	
