package com.hashedin.broadcast.searchengine.sql.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @OneToOne
    @JoinColumn(name = "hasher_ID")
    private Hasher hasher;

}