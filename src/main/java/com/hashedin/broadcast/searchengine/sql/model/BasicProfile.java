package com.hashedin.broadcast.searchengine.sql.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasicProfile {

    @Id
    @SequenceGenerator(name = "basic_profile_seq", sequenceName = "basic_profile_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "basic_profile_seq")
    private Long id;
    private String name;
    @Column(columnDefinition = "text")
    private String profilePic;
}
