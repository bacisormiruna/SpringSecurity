package com.example.demoM.service.event;

import com.example.demoM.model.Event;

import java.util.List;

public interface EventService {

    List<Event> getAllEvents();
    Event addEvent(Event event);

    Event getEventById(Integer id);

    void deleteEventById(Integer id);

    void createEvent(Event event);
}