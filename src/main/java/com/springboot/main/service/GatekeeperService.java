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