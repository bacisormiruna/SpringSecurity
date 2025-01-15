package com.example.demoM.dto;

import com.example.demoM.model.Tag;
import lombok.Builder;

@Builder
public record TagDto(
        String name
) {
    // Constructor pentru a crea un TagDto dintr-un Tag
    public TagDto(Tag tag) {
        this(tag.getName());  // Apelează constructorul principal cu valoarea corespunzătoare
    }
}
