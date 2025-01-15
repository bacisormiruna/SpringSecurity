package com.example.demoM.dto;

import lombok.Builder;

@Builder
public record EventDto(
        String name,
        String eventCategory,
        String eventDetails
) {}
