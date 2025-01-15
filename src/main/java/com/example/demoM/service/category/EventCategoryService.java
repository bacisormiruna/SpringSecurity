package com.example.demoM.service.category;

import com.example.demoM.model.EventCategory;

import java.util.List;


public interface EventCategoryService {
    List<EventCategory> getAllEventCategories();
    EventCategory getEventById(Integer id);
    void addCategory(EventCategory eventCategory);
    EventCategory getEventByName(String name);
}

