package com.hashedin.broadcast.searchengine.sql.model;

import javax.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user_table")
public class User {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;

    @OneToOne
    @JoinColumn(name = "basic_profile_id", referencedColumnName = "id")
    private BasicProfile basicProfile;




}
