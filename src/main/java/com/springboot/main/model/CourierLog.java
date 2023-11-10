package com.springboot.main.model;

import java.time.LocalDateTime;

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
	private LocalDateTime entryTime;
	private LocalDateTime exitTime;

	@ManyToOne
	private Gatekeeper gateKeeper;
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

	
	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}

	public LocalDateTime getExitTime() {
		return exitTime;
	}

	public void setExitTime(LocalDateTime exitTime) {
		this.exitTime = exitTime;
	}

	public Gatekeeper getGateKeeper() {
		return gateKeeper;
	}

	public void setGateKeeper(Gatekeeper gateKeeper) {
		this.gateKeeper = gateKeeper;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}
}
