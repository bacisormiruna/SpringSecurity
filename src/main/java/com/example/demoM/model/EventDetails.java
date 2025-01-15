package com.example.demoM.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Builder
@Table(name = "event_details")
public class EventDetails extends AbstractEntity {

    private String description;
    private String contactEmail;

    // Constructor fără parametri pentru JPA
    public EventDetails() {}

    // Constructor cu parametri pentru builder
    public EventDetails(String description, String contactEmail) {
        this.description = description;
        this.contactEmail = contactEmail;
    }

    // Getter și setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }
}
