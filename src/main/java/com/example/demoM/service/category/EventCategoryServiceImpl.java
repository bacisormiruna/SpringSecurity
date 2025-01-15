package com.example.demoM.service.category;

import com.example.demoM.model.EventCategory;
import com.example.demoM.repository.EventCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventCategoryServiceImpl implements EventCategoryService {

    private final EventCategoryRepository eventCategoryRepository;

    @Override
    public List<EventCategory> getAllEventCategories() {
        return eventCategoryRepository.findAll();
    }

    @Override
    public EventCategory getEventById(Integer id) {
        return eventCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category with ID " + id + " does not exist."));
    }
}