package com.example.demoM.dto;

import lombok.Builder;

@Builder
public record EventDetailsDto(
        String description,
        String contactEmail
) {}
