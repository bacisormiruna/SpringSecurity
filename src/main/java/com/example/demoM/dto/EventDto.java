package com.example.demoM.dto;

import lombok.Builder;

@Builder
public record EventDto(
        String name,
        EventCategoryDto eventCategory,
        EventDetailsDto eventDetails
        //List<TagDto> tags
) {}
