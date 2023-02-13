package com.postgresdata.repository.postgresql;

import com.postgresdata.model.postgresql.BasicProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasicProfileRepository extends JpaRepository<BasicProfile,Long> {

}
