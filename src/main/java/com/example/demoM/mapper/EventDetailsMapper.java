package com.example.demoM.mapper;

import com.example.demoM.dto.EventDetailsDto;
import com.example.demoM.model.EventDetails;
import org.springframework.stereotype.Component;

@Component
public class EventDetailsMapper {

    public EventDetailsDto eventDetailsEntityToDto(EventDetails eventDetails) {
        return EventDetailsDto.builder()
                .description(eventDetails.getDescription())
                .contactEmail(eventDetails.getContactEmail())
                .build();
    }

    public EventDetails eventDetailsDtoToEntity(EventDetailsDto eventDetailsDto) {
        return EventDetails.builder()
                .description(eventDetailsDto.description())
                .contactEmail(eventDetailsDto.contactEmail())
                .build();
    }
}