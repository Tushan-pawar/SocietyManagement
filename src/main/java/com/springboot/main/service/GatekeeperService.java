<<<<<<< HEAD
<<<<<<< HEAD
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

<<<<<<< HEAD
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
=======
	public Gatekeeper insert(Gatekeeper gatekeeper) {
		return gatekeeperRepository.save(gatekeeper);
	}
}
=======
package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.GateKeeper;
import com.springboot.main.repository.GateKeeperRepository;

	@Service
	public class GateKeeperService {
	@Autowired
	private GateKeeperRepository gateKeeperRepository;
	public GateKeeper insert(GateKeeper gatekeeper) {
		return gateKeeperRepository.save(gatekeeper);
	}
	}
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
=======
package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.GateKeeper;
import com.springboot.main.repository.GateKeeperRepository;

	@Service
	public class GateKeeperService {
	@Autowired
	private GateKeeperRepository gateKeeperRepository;
	public GateKeeper insert(GateKeeper gatekeeper) {
		return gateKeeperRepository.save(gatekeeper);
	}
	}
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
>>>>>>> 1d7f627400cf2ed935338c192d15398243bbc147
