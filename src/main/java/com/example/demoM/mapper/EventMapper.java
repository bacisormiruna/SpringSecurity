package com.example.demoM.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EventMapper {
    /*public Event eventEntityToDto(Event event) {
        return new Event(
                event.getName(),
                event.getEventCategory(),
                event.getEventDetails()
        );
    }

    public List<EventDto> eventListEntityToDto(List<Event> events) {
        return events.stream()
                .map(this::eventEntityToDto)
                .toList();
    }*/
}