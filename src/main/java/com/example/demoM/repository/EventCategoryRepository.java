package com.example.demoM.repository;

import com.example.demoM.model.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventCategoryRepository extends JpaRepository<EventCategory, Integer> {
    List<EventCategory> findAll();
}
