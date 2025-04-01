package com.example.buses_ms.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "buses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
//@Builder // Allows to apply a builder pattern.
@EntityListeners(AuditingEntityListener.class) // Allows to JPA manage the columns with createdAt Date values
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @UuidGenerator
    private UUID id;
    @Column(name = "bus_number", nullable = false, unique = true)
    private Integer busNumber;

    @Column(name = "bus_plate", nullable = false, unique = true, length = 17)
    private String plate;

    @CreatedDate
    @Column(name = "bus_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "bus_characteristics", nullable = true, columnDefinition = "TEXT")
    private String characteristics;

    //@Column(name = "bus_brand", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY) // Load only when is needed
    @JoinColumn(name = "brand_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_bus_brand"))
    private Brand brand;

    @Column(name = "bus_status", nullable = false)
    private Boolean status;


}
