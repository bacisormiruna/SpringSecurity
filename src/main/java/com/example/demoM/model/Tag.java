package com.example.demoM.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NaturalId;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TAGS")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    @Column(unique = true) // Numele trebuie să fie unic
    private String name;

   /* @Singular
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "events_tags",
            joinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id")
    )
    private List<Event> events = new ArrayList<>();*/

    @Builder.Default
    private Boolean active = true;  // Dacă tag-ul este activ sau nu (optional)

    @NaturalId(mutable = true)  // Permite modificarea numelui, dar îl menține unic
    private String displayName;  // Afișează un nume mai prietenos sau personalizat pentru tag (opțional)

}