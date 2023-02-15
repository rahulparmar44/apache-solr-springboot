package com.searchengine.jparepository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CertificationProvider {

    @Id
    @SequenceGenerator(name = "certification_provider_seq", sequenceName = "certification_provider_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "certification_provider_seq")
    private Long id;
    private String name;
    private String imageUrl;
}
