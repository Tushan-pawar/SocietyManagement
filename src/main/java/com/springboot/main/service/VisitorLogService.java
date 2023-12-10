
package com.springboot.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.VisitorLog;
import com.springboot.main.repository.VisitorLogRepository;

@Service
public class VisitorLogService {
	@Autowired
	private VisitorLogRepository visitorLogRepository;

	public VisitorLog insert(VisitorLog visitorLog) {
		// TODO Auto-generated method stub
		return visitorLogRepository.save(visitorLog);
	}

	public List<VisitorLog> getVisitorLogsByResidentId(int residentId) {
		  return visitorLogRepository.findByResidentId(residentId);
	}

	 public List<VisitorLog> getAllVisitorLogs() {
	        return visitorLogRepository.findAll();
	    }
	}

	

