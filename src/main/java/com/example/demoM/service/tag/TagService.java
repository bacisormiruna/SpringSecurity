package com.example.demoM.service.tag;

import com.example.demoM.model.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAllTags();
   Tag getTagById(Integer id);
    void addTag(Tag tag);
    Tag getTagByName(String name);
    void updateTag(Tag tag);
}
