<<<<<<< HEAD
package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.Bill;
import com.springboot.main.repository.BillRepository;

@Service
public class BillService {
@Autowired
private BillRepository billRepository;

public Bill insert(Bill bill) {
	// TODO Auto-generated method stub
	return billRepository.save(bill);
}
}
=======
package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.Bill;
import com.springboot.main.repository.BillRepository;

@Service
public class BillService {
@Autowired
private BillRepository billRepository;

public Bill insert(Bill bill) {
	// TODO Auto-generated method stub
	return billRepository.save(bill);
}
}
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
