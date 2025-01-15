package com.example.demoM.dto;

import lombok.Builder;

@Builder
public record EventCategoryDto(
        String name,
        String description
) {}
