package com.springboot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.main.model.Gatekeeper;

@Repository
public interface GatekeeperRepository extends JpaRepository <Gatekeeper, Integer> {
}
