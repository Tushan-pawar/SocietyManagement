package com.springboot.main.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.main.model.Event;
import com.springboot.main.service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
@Autowired 
private EventService eventService;

@PostMapping("/add")
public Event insertEvent(@RequestBody Event event) {
    event= eventService.insertEvent(event);
    return event;
}

@GetMapping("/getallevents")
public List<Event> getAllEvents() {
    return eventService.getAllEvents();
}
}
