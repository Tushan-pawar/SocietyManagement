package com.springboot.main.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CourierLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String courierName;
	private LocalDate entryTime;

	@ManyToOne
	private Gatekeeper gatekeeper;
	@ManyToOne
	private Resident resident;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourierName() {
		return courierName;
	}

	public void setCourierName(String courierName) {
		this.courierName = courierName;
	}

	
	public LocalDate getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDate entryTime) {
		this.entryTime = entryTime;
	}

	

	public void setGatekeeper(Gatekeeper gatekeeper) {
		this.gatekeeper = gatekeeper;
	}

	public Gatekeeper getGatekeeper() {
		return gatekeeper;
	}

	public void setGateKeeper(Gatekeeper gatekeeper) {
		this.gatekeeper = gatekeeper;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}
}