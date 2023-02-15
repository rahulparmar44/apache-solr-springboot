package com.searchengine.jparepository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertifiedHashersSummary {
    @Id
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Hasher> hashersCertified;

    private int count;

    private boolean isCertified;

    private boolean isEnrolled;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Enrollment enrollment;
}