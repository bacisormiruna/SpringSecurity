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
    public EventDto addEvent(Event event) {
        Event savedEvent = eventRepository.save(event);
        return eventMapper.eventEntityToDto(savedEvent);
    }

    @Override
    public EventDto getEventById(Integer id) {
        return eventRepository.findById(id)
                .map(eventMapper::eventEntityToDto)
                .orElseThrow(() -> new IllegalArgumentException("Event with ID " + id + " does not exist."));
    }


    @Override
    public void deleteEvent(Integer id) {
        if (eventRepository.existsById(id)) {
            eventRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Event with ID " + id + " does not exist.");
        }
    }
}