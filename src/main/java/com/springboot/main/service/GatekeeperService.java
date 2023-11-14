package com.springboot.main.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.exception.InvalidIdException;
import com.springboot.main.model.Gatekeeper;
import com.springboot.main.repository.GatekeeperRepository;

@Service
public class GatekeeperService {
	@Autowired
	private GatekeeperRepository gatekeeperRepository;

public Gatekeeper insert(Gatekeeper gatekeeper) {
		return gatekeeperRepository.save(gatekeeper);
	}

/*	public Gatekeeper getGatekeeperById(int gatekeeperId) {
		// TODO Auto-generated method stub
		return gatekeeperRepository.findByGatekeeperId(gatekeeperId);
	}*/

	
	public Gatekeeper getOne(int gatekeeperId) throws InvalidIdException {
		Optional<Gatekeeper> optional =gatekeeperRepository.findById(gatekeeperId);
		if(!optional.isPresent()){
			throw new InvalidIdException("gatekeeper ID Invalid");
		}
		return optional.get();
	}

	
}