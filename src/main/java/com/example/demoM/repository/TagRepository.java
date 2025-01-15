package com.example.demoM.repository;

import com.example.demoM.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
   /* // Metodă pentru a găsi toate etichetele (implicit în JpaRepository, dar adăugată pentru claritate)
    @Override
    List<Tag> findAll();

    // Metodă pentru a găsi o etichetă pe baza ID-ului
    @Override
    Optional<Tag> findById(Integer id);

    // Metodă pentru a găsi o etichetă pe baza numelui
    Optional<Tag> findByName(String name);

    // Metodă pentru a verifica dacă o etichetă există pe baza numelui
    boolean existsByName(String name);

    // Metodă pentru a găsi toate etichetele care conțin un anumit text în nume (case-insensitive)
    @Query("SELECT t FROM Tag t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Tag> findByNameContainingIgnoreCase(String name);

    // Metodă pentru a șterge o etichetă pe baza ID-ului
    @Override
    void deleteById(Integer id);

    // Metodă pentru a găsi primele N etichete ordonate alfabetic
    List<Tag> findTop3ByOrderByNameAsc();

    // Metodă pentru a găsi toate etichetele asociate unui eveniment (presupunând o relație între Tag și Event)
    @Query("SELECT t FROM Tag t JOIN t.events e WHERE e.id = :eventId")
    List<Tag> findTagsByEventId(Integer eventId);*/
}
