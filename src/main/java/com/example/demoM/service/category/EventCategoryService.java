package com.example.demoM.service.category;

import com.example.demoM.model.EventCategory;

import java.util.List;


public interface EventCategoryService {
    List<EventCategory> getAllEventCategories();

    // Găsește o categorie de eveniment după ID
    EventCategory getEventById(Integer id);
}

