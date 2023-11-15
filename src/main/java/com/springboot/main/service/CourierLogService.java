package com.springboot.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.CourierLog;
import com.springboot.main.repository.CourierLogRepository;

@Service
public class CourierLogService {
	@Autowired
	private CourierLogRepository courierLogRepository;

	public CourierLog insert(CourierLog courierLog) {
		return courierLogRepository.save(courierLog);
	}

	public List<CourierLog> getCourierLogByResident(int residentId) {
		return courierLogRepository.findByResidentId(residentId);
	}
}