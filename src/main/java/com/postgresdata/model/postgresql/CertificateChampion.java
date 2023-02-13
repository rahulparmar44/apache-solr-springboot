package com.postgresdata.model.postgresql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CertificateChampion {
    @Id
    @SequenceGenerator(name = "certificate_champion_seq", sequenceName = "certificate_champion_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certificate_champion_seq")
    private Long id;
    private String delEmail;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "certification_id")
    private Certification certification;
}
