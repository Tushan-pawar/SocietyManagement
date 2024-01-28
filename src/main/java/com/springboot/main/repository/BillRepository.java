package com.springboot.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.main.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

	List<Bill> findByResidentId(int residentId);

	
	@Query("SELECT b FROM Bill b WHERE b.paid = NULL and b.paid =0")
	List<Bill> getUnpaidBills();

	@Query("SELECT b FROM Bill b WHERE b.paid = 1")
	List<Bill> getPaidBills();

	@Query("SELECT b FROM Bill b WHERE b.particulars = 'Water Bill'")
	List<Bill> getWaterBill();

	 @Query("SELECT b FROM Bill b WHERE b.resident.id = :residentId AND b.paid = 1 and b.paid= paid")
	    List<Bill> getPaidBillsByResident(@Param("residentId") Long residentId);
	
}
