package com.example.demoM.repository;

import com.example.demoM.model.Event;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
    // Metodă pentru a găsi toate evenimentele (implicit din JpaRepository, dar adăugată pentru claritate)
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"eventCategory"})
    List<Event> findAll();
}

