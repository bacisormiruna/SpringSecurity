package com.example.demoM.repository;

import com.example.demoM.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer>{
    List<Tag> findAll();
    Tag findByName(String name);
}
