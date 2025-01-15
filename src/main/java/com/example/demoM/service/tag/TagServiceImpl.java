package com.example.demoM.service.tag;

import com.example.demoM.model.Tag;
import com.example.demoM.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService{

    private final TagRepository tagRepository;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTagById(Integer id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tag with ID " + id + " does not exist."));
    }

    @Override
    public void addTag(Tag tag) {
        tagRepository.save(tag);
    }

    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    // Actualizează un tag
    public void updateTag(Tag tag) {
        tagRepository.save(tag); // Save va face update dacă tag-ul există deja
    }

}
