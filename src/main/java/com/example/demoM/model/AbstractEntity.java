package com.example.demoM.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data // Generează getter, setter, toString, hashCode și equals
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    // Equals și hashCode sunt generate de Lombok
    // @EqualsAndHashCode.Include asigură includerea câmpului `id` în calculul hashCode și equals
    @EqualsAndHashCode.Include
    public int getId() {
        return id;
    }
}
