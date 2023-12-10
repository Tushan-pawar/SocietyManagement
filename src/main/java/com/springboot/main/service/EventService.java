
package com.springboot.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.main.model.Event;
import com.springboot.main.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	public Event insert(Event event) {
		return eventRepository.save(event);
	}
	public Page<Event> getAllEvents(Pageable pageable) {
	    return eventRepository.findAll(pageable);
	}

	public Optional<Event> findById(int id) {
		// TODO Auto-generated method stub
		return eventRepository.findById(id);
	}
}
