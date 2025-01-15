package com.example.demoM.service.category;

import com.example.demoM.model.EventCategory;
import com.example.demoM.repository.EventCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Override
    public void addCategory(EventCategory eventCategory) {
        eventCategoryRepository.save(eventCategory);
    }

    public EventCategory getEventByName(String name) {
        return eventCategoryRepository.findByName(name).orElse(null);
    }
}