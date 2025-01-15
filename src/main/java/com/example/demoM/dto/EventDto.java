package com.example.demoM.dto;

import com.example.demoM.model.EventCategory;
import com.example.demoM.model.EventDetails;
import lombok.Builder;

@Builder
public record EventDto(
        String name,
        EventCategory eventCategory,
        EventDetails eventDetails
) {}
