<<<<<<< HEAD
<<<<<<< HEAD
package com.springboot.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.Gatekeeper;
import com.springboot.main.repository.GatekeeperRepository;

@Service
public class GatekeeperService {
	@Autowired
	private GatekeeperRepository gatekeeperRepository;

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
