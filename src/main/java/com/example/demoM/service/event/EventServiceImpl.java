package com.example.demoM.service.event;

import com.example.demoM.dto.EventDto;
import com.example.demoM.mapper.EventMapper;
import com.example.demoM.model.Event;
import com.example.demoM.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public List<EventDto> getAllEvents() {
        return eventMapper.eventListEntityToDto(eventRepository.findAll());
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
    public EventDto getEventById(Integer id) {
        // Găsește un eveniment după ID
        return eventMapper.eventEntityToDto(eventRepository.findById(id).orElse(null));
    }
}