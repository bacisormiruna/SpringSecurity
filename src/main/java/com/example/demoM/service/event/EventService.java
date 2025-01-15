package com.example.demoM.service.event;

import com.example.demoM.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    // Metodă pentru a obține toate evenimentele
    List<Event> getAllEvents();

    // Metodă pentru a adăuga un eveniment nou
    Event addEvent(Event event);

    // Metodă pentru a șterge un eveniment după ID
    void deleteEvent(Integer id);

    // Metodă pentru a găsi un eveniment după ID
    Optional<Event> getEventById(Integer id);
}