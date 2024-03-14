package com.mysite.basketproject.event;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventService {

    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
}
