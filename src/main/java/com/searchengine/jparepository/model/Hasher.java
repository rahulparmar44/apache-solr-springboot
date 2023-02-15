package com.searchengine.jparepository.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hasher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "detailed_profile_ID")
    private DetailedProfile detailedProfile;

    @OneToOne
    private BasicProfile basicProfile;
}