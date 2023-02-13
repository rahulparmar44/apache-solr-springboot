package com.postgresdata.model.postgresql;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(columnDefinition = "text")
    private String description;
    private int level;
    private int validity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "offered_by_id", referencedColumnName = "id")
    private CertificationProvider offeredBy;

    private String certificationType;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "certification"
    )
    private List<CertificateChampion> certificateChampions;

    private Integer openForEnrollmentTill;
    private Boolean isPublished;
    private Integer durationInWeeks;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "certified_hashers_summary_ID", referencedColumnName = "id")
    private CertifiedHashersSummary certifiedHashersSummary;

    @OneToMany(mappedBy = "id")
    private List<Capability> capability;
}