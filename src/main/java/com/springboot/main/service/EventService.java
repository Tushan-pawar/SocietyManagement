<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
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

<<<<<<< HEAD
}
=======
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
>>>>>>> 5dc1a4fcc131349ec52e4e213d2b9f911445b8ce
