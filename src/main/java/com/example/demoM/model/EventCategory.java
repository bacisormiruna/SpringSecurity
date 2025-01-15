package com.example.demoM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder(toBuilder = true)
@Entity
public class EventCategory extends AbstractEntity {

    @Size(min = 3, message = "Name must be at least 3 characters long")
    private String name;

    @Size(min = 5, message = "Description must be at least 5 characters long")
    private String description;

    @OneToMany(mappedBy = "eventCategory")
    @Builder.Default
    private List<Event> events = new ArrayList<>();

    @Override
    public String toString() {
        return name;
    }
}