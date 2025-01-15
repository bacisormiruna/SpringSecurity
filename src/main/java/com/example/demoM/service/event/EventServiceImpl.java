package com.example.demoM.service.event;

import com.example.demoM.model.Event;
import com.example.demoM.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return eventRepository.save(event);
    }

    @Override
    public Event getEventById(Integer id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Event with ID " + id + " does not exist."));
    }

    @Override
    public void deleteEventById(Integer id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Event with ID " + id + " does not exist.");
        }
    }
    @Override
    public void createEvent(Event event) {
        addEvent(event);
    }
}