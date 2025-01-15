package com.example.demoM.service.event;

import com.example.demoM.dto.EventDto;
import com.example.demoM.model.Event;

import java.util.List;

public interface EventService {
    List<EventDto> getAllEvents();

    // Metodă pentru a adăuga un eveniment
    EventDto addEvent(Event event);

    // Metodă pentru a obține un eveniment după ID
    EventDto getEventById(Integer id);

    // Metodă pentru a șterge un eveniment după ID
    void deleteEvent(Integer id);

}