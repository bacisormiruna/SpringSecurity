package com.example.demoM.mapper;

import com.example.demoM.dto.TagDto;
import com.example.demoM.model.Tag;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TagMapper {

    // Maparea din Tag în TagDto
    public TagDto tagEntityToDto(Tag tag) {
        if (tag == null) {
            return null;
        }
        return TagDto.builder()
                .name(tag.getName()) // Maparea câmpului 'name' din Tag în TagDto
                .build();
    }

    // Maparea din lista de Tag în lista de TagDto
    public List<TagDto> tagListEntityToDto(List<Tag> tags) {
        if (tags == null) {
            return null;
        }
        return tags.stream()
                .map(this::tagEntityToDto)
                .collect(Collectors.toList());
    }

    // Maparea din TagDto în Tag
    public Tag tagDtoToEntity(TagDto tagDto) {
        if (tagDto == null) {
            return null;
        }
        return Tag.builder()
                .name(tagDto.name()) // Maparea câmpului 'name' din TagDto în Tag
                .build();
    }

    // Maparea din lista de TagDto în lista de Tag
    public List<Tag> tagListDtoToEntity(List<TagDto> tagDtos) {
        if (tagDtos == null) {
            return null;
        }
        return tagDtos.stream()
                .map(this::tagDtoToEntity)
                .collect(Collectors.toList());
    }
}
