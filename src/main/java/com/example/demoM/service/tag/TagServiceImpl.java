package com.example.demoM.service.tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    /*private final TagRepository tagRepository;

    @Override
    public List<TagDto> getAllTags() {
        return tagRepository.findAll().stream()
                .map(TagDto::new)  // Folosim constructorul TagDto(Tag tag)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TagDto> getTagById(Integer tagId) {
        return tagRepository.findById(tagId).map(TagDto::new);  // La fel, mapăm Tag în TagDto
    }

    @Override
    public Tag saveTag(TagDto tagDto) {
        Tag tag = new Tag();  // Creăm o entitate Tag din TagDto
        tag.setName(tagDto.name());  // Accesăm valoarea din TagDto pentru a seta câmpul name
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Integer tagId) {
        tagRepository.deleteById(tagId);
    }*/
}