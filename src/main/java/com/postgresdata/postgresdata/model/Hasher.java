package com.postgresdata.postgresdata.model;

import jakarta.persistence.*;
import lombok.*;

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