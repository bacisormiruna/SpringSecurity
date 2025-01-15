package com.example.demoM.mapper;

import com.example.demoM.dto.EventDto;
import com.example.demoM.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EventMapper {
    public EventDto eventEntityToDto(Event event) {
        return new EventDto(
                event.getName(),
                event.getEventCategory(),
                event.getEventDetails()
        );
    }

    public List<EventDto> eventListEntityToDto(List<Event> events) {
        return events.stream()
                .map(this::eventEntityToDto)
                .toList();
    }
}