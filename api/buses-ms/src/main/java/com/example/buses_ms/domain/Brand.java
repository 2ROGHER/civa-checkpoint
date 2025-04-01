package com.example.buses_ms.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Table(name="brands")
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    private UUID id;

    @Column(name="brand_name", nullable = false, unique = true)
    private String name;

    @Column(name="brand_description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name="brand_country", nullable = false)
    private String country;

    @Column(name="brand_sector", nullable = false)
    private String sector;

    // 1. Make relationship between [Bus] and [Brand]
    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true) // If any [bus] let relationships with any [brand] this is deleted
    private List<Bus> buses;

}
