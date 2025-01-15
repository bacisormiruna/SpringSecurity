package com.example.demoM.mapper;

import com.example.demoM.dto.EventDto;
import com.example.demoM.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class EventMapper {


    // Maparea din Event în EventDto
    public EventDto eventEntityToDto(Event event) {
        return EventDto.builder()
                .name(event.getName())
                .eventCategory(event.getEventCategory()) // Mapăm numele categoriei din entitatea Category
                .eventDetails(event.getEventDetails()) // Mapăm EventDetails
                .build();
    }

    // Maparea din lista de Event în lista de EventDto
    public List<EventDto> eventListEntityToDto(List<Event> events) {
        return events.stream()
                .map(this::eventEntityToDto)
                .collect(Collectors.toList());
    }

    // Maparea din EventDto în Event
    public Event eventDtoToEntity(EventDto eventDto) {

        return Event.builder()
                .name(eventDto.name())
                .eventCategory(eventDto.eventCategory())
                .eventDetails(eventDto.eventDetails())
                .build();
    }

    public List<Event> eventListDtoToEntity(List<EventDto> eventDtos) {
        return eventDtos.stream()
                .map(this::eventDtoToEntity)
                .collect(Collectors.toList());
    }
}