package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.CourierLog;
import com.springboot.main.repository.CourierRepository;

@Service
public class CourierService {
	@Autowired
	private CourierRepository courierRepository;

	public CourierLog insert(CourierLog courierLog) {
		return courierRepository.save(courierLog);
	}

}
