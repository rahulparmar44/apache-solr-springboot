package com.postgresdata.model.postgresql;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailedProfile {

    @Id
    @SequenceGenerator(name = "detailed_profile_seq", sequenceName = "detailed_profile_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detailed_profile_seq")
    private Long id;

    private String delEmail;

    @OneToOne
    private User user;
}