package com.example.demoM.service.event;

import com.example.demoM.model.Event;
import com.example.demoM.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event addEvent(Event event) {
        // Salvează evenimentul și returnează-l
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Integer id) {
        // Șterge evenimentul după ID
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Event with ID " + id + " does not exist.");
        }
    }

    @Override
    public Optional<Event> getEventById(Integer id) {
        // Găsește un eveniment după ID
        return eventRepository.findById(id);
    }
}