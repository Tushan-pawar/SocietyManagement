
package com.springboot.main.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Resident;
import com.springboot.main.repository.ResidentRepository;


@Service
public class ResidentService {
	@Autowired
	private ResidentRepository residentRepository;
	public Resident insert(Resident resident) {
		return residentRepository.save(resident);
	}
	public List<Resident> getAllResidents() {
		return residentRepository.findAll();
	}
	public Resident getOne(int id) throws InvalidIdException {
		Optional<Resident> optional =  residentRepository.findById(id);
		if(!optional.isPresent()){
			throw new InvalidIdException("resident ID Invalid");
		}
		return optional.get();
	}
	public void deleteResident(Resident resident) {
		 residentRepository.delete(resident);
	}
	public Resident updateResident(int id, Resident resident) throws InvalidIdException {
            resident.setId(id);
            return residentRepository.save(resident);
    
    }
}