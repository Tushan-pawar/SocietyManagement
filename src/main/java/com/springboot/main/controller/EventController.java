<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.main.model.Event;
import com.springboot.main.service.EventService; 
@Controller
@RequestMapping("/events")
public class EventController {
    @Autowired 
    private EventService eventService;

    @PostMapping("/add")
    public Event insertEvent(@RequestBody Event event) {
        event = eventService.insertEvent(event);
        return event;
    }
}
<<<<<<< HEAD
=======
=======
package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.main.model.Event;
import com.springboot.main.service.EventService;

@Controller
@RequestMapping("/events")
public class EventController {
@Autowired 
private EventService eventService;

@PostMapping("/add")
public Event insertEvent(@RequestBody Event event) {
    event= eventService.insertEvent(event);
    return event;
}


}
>>>>>>> bc1f25922778682115cb590275a680864198a72b
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
