package com.example.demoM.service.event;

import com.example.demoM.dto.EventDto;
import com.example.demoM.model.Event;
import com.example.demoM.model.EventRequest;

import java.util.List;

public interface EventService {
    List<EventDto> getAllEvents();

    EventDto registerEvent(EventRequest registrationRequest);

    EventDto addEvent(Event event);

    EventDto getEventById(Integer id);

    EventDto updateEvent(Integer id, EventDto eventDto);

    void deleteEvent(Integer id);
}