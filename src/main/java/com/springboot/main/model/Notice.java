<<<<<<< HEAD
package com.springboot.main.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String content;
	private LocalDate date;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


=======
package com.springboot.main.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String content;
	private LocalDate date;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
}