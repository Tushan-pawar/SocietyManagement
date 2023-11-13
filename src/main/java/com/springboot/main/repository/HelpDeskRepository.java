package com.springboot.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.main.model.HelpDesk;

public interface HelpDeskRepository extends JpaRepository<HelpDesk, Integer> {

}
