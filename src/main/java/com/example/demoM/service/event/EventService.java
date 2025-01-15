package com.example.demoM.service.event;

import com.example.demoM.dto.EventDto;
import com.example.demoM.model.Event;

import java.util.List;

public interface EventService {
    // Metodă pentru a obține toate evenimentele
    List<Event> getAllEvents();

    // Metodă pentru a adăuga un eveniment nou
    Event addEvent(Event event);

    // Metodă pentru a șterge un eveniment după ID
    void deleteEvent(Integer id);

    // Metodă pentru a găsi un eveniment după ID
     EventDto getEventById(Integer id);
}