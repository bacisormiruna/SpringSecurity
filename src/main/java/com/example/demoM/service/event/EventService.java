package com.example.demoM.service.event;

import com.example.demoM.model.Event;

import java.util.List;

public interface EventService {
    // Obține toate evenimentele
    List<Event> getAllEvents();

    // Adaugă un nou eveniment
    Event addEvent(Event event);

    // Găsește un eveniment după ID
    Event getEventById(Integer id);

    // Șterge un eveniment
    void deleteEventById(Integer id);

    // Creează un nou eveniment
    Event createEvent(Event event);
}