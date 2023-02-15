package com.searchengine.jparepository.model;

import lombok.*;

import javax.persistence.*;

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
