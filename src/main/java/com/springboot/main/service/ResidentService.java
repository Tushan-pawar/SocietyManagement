package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.Resident;
import com.springboot.main.repository.ResidentRepository;
@Service
public class ResidentService {
	@Autowired
	private ResidentRepository residentRepository;
	public Resident insert(Resident resident) {
		return residentRepository.save(resident);
	}

}
