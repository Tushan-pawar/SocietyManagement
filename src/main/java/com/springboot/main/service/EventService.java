<<<<<<< HEAD
package com.springboot.main.service;

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

    // You can add other service methods as needed

}
=======
package com.springboot.main.service;

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

    // You can add other service methods as needed

}
>>>>>>> bc1f25922778682115cb590275a680864198a72b
