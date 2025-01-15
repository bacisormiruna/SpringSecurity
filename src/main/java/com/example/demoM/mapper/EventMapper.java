package com.example.demoM.mapper;

import com.example.demoM.dto.EventDto;
import com.example.demoM.model.Event;
import com.example.demoM.model.EventCategory;
import com.example.demoM.model.EventDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class EventMapper {

    private final EventCategoryMapper eventCategoryMapper;
    //private final TagMapper tagMapper;
    private final EventDetailsMapper eventDetailsMapper;

    // Maparea din Event în EventDto
    public EventDto eventEntityToDto(Event event) {
        return EventDto.builder()
                .name(event.getName())
                .eventCategory(eventCategoryMapper.eventCategoryEntityToDto(event.getEventCategory())) // Mapăm EventCategory
                .eventDetails(eventDetailsMapper.eventDetailsEntityToDto(event.getEventDetails())) // Mapăm EventDetails
                //.tags(tagMapper.tagListEntityToDto(event.getTags())) // Mapăm lista de Tag-uri
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
        EventCategory eventCategory = eventCategoryMapper.eventCategoryDtoToEntity(eventDto.eventCategory()); // Mapăm EventCategory
        EventDetails eventDetails = eventDetailsMapper.eventDetailsDtoToEntity(eventDto.eventDetails()); // Mapăm EventDetails
       // List<Tag> tags = tagMapper.tagListDtoToEntity(eventDto.tags()); // Mapăm lista de Tag-uri

        return Event.builder()
                .name(eventDto.name())
                .eventCategory(eventCategory)
                .eventDetails(eventDetails)
                //.tags(tags)
                .build();
    }

    public List<Event> eventListDtoToEntity(List<EventDto> eventDtos) {
        return eventDtos.stream()
                .map(this::eventDtoToEntity)
                .collect(Collectors.toList());
    }
}