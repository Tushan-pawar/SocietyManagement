package com.springboot.main.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;


import com.springboot.main.model.Gatekeeper;

public interface GatekeeperRepository extends JpaRepository<Gatekeeper, Integer> {

	//Gatekeeper findByGatekeeperId(int gatekeeperId);

	Optional<Gatekeeper> findById(int gatekeeperId);
}
