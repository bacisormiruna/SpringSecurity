package com.example.demoM.mapper;

import com.example.demoM.dto.EventCategoryDto;
import com.example.demoM.model.EventCategory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventCategoryMapper {

    // Maparea din EventCategory în EventCategoryDto
    public EventCategoryDto eventCategoryEntityToDto(EventCategory eventCategory) {
        return EventCategoryDto.builder()
                .name(eventCategory.getName()) // presupunem că EventCategory are un câmp `name`
                .description(eventCategory.getDescription()) // presupunem că EventCategory are un câmp `description`
                .build();
    }

    // Maparea din lista de EventCategory în lista de EventCategoryDto
    public List<EventCategoryDto> eventCategoryListEntityToDto(List<EventCategory> eventCategories) {
        return eventCategories.stream()
                .map(this::eventCategoryEntityToDto)
                .collect(Collectors.toList());
    }

    // Maparea din EventCategoryDto în EventCategory
    public EventCategory eventCategoryDtoToEntity(EventCategoryDto eventCategoryDto) {
        return EventCategory.builder()// presupunem că EventCategoryDto are un câmp `description`
                .build();
    }

    // Maparea din lista de EventCategoryDto în lista de EventCategory
    public List<EventCategory> eventCategoryListDtoToEntity(List<EventCategoryDto> eventCategoryDtos) {
        return eventCategoryDtos.stream()
                .map(this::eventCategoryDtoToEntity)
                .collect(Collectors.toList());
    }
}