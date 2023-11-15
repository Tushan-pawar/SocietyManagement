
package com.springboot.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.main.model.Event;
import com.springboot.main.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	public Event insertEvent(Event event) {
		return eventRepository.save(event);
	}
	 public List<Event> getAllEvents() {
	        return eventRepository.findAll();
	    }
}
