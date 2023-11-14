<<<<<<< HEAD
package com.springboot.main.service;

import java.util.List;
<<<<<<< HEAD


=======
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Resident;
import com.springboot.main.repository.ResidentRepository;

<<<<<<< HEAD
=======
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147
@Service
public class ResidentService {
	@Autowired
	private ResidentRepository residentRepository;

	public Resident insert(Resident resident) {
		return residentRepository.save(resident);
	}
	/* srikanya code */
<<<<<<< HEAD
=======

	public List<Resident> getAllResidents() {
		// TODO Auto-generated method stub
		return residentRepository.findAll();
	}

	public Resident getOne(int id) throws InvalidIdException {
		Optional<Resident> optional = residentRepository.findById(id);
		if (!optional.isPresent()) {
			throw new InvalidIdException("resident ID Invalid");
		}
		return optional.get();
	}

	public void deleteResident(Resident resident) {
		// TODO Auto-generated method stub
		residentRepository.delete(resident);
	}
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147

	public List<Resident> getAllResidents() {
		// TODO Auto-generated method stub
		return residentRepository.findAll();
	}

	public Resident getOne(int residentId) throws InvalidIdException {
		Optional<Resident> optional = residentRepository.findById(residentId);
		if (!optional.isPresent()) {
			throw new InvalidIdException("resident ID Invalid");
		}
		return optional.get();
	}

	public void deleteResident(Resident resident) {
		// TODO Auto-generated method stub
		residentRepository.delete(resident);
	}

	
}
=======
package com.springboot.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Resident;
import com.springboot.main.repository.ResidentRepository;


>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
@Service
public class ResidentService {
	@Autowired
	private ResidentRepository residentRepository;

	public Resident insert(Resident resident) {
		return residentRepository.save(resident);
	}
<<<<<<< HEAD
	/* srikanya code */

=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
	public List<Resident> getAllResidents() {
		// TODO Auto-generated method stub
		return residentRepository.findAll();
	}
<<<<<<< HEAD

	public Resident getOne(int id) throws InvalidIdException {
		Optional<Resident> optional = residentRepository.findById(id);
		if (!optional.isPresent()) {
=======
	public Resident getOne(int id) throws InvalidIdException {
		Optional<Resident> optional =  residentRepository.findById(id);
		if(!optional.isPresent()){
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
			throw new InvalidIdException("resident ID Invalid");
		}
		return optional.get();
	}
<<<<<<< HEAD

	public void deleteResident(Resident resident) {
		// TODO Auto-generated method stub
		residentRepository.delete(resident);
	}

}
=======
package com.springboot.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Resident;
import com.springboot.main.repository.ResidentRepository;


>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
@Service
public class ResidentService {
	@Autowired
	private ResidentRepository residentRepository;

	public Resident insert(Resident resident) {
		return residentRepository.save(resident);
	}
<<<<<<< HEAD
	/* srikanya code */

=======
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
	public List<Resident> getAllResidents() {
		// TODO Auto-generated method stub
		return residentRepository.findAll();
	}
<<<<<<< HEAD

	public Resident getOne(int id) throws InvalidIdException {
		Optional<Resident> optional = residentRepository.findById(id);
		if (!optional.isPresent()) {
=======
	public Resident getOne(int id) throws InvalidIdException {
		Optional<Resident> optional =  residentRepository.findById(id);
		if(!optional.isPresent()){
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
			throw new InvalidIdException("resident ID Invalid");
		}
		return optional.get();
	}
<<<<<<< HEAD

	public void deleteResident(Resident resident) {
		// TODO Auto-generated method stub
		residentRepository.delete(resident);
	}

=======
	public void deleteResident(Resident resident) {
		// TODO Auto-generated method stub
		 residentRepository.delete(resident);
	}
	
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
}
=======
	public void deleteResident(Resident resident) {
		// TODO Auto-generated method stub
		 residentRepository.delete(resident);
	}
	
}
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
>>>>>>> bc1f25922778682115cb590275a680864198a72b
