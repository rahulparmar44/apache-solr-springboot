package com.postgresdata.model.postgresql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Capability {

    @Id
    @SequenceGenerator(name = "capability_seq", sequenceName = "capability_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "capability_seq")
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "certification_id")
    private Certification certification;

}
