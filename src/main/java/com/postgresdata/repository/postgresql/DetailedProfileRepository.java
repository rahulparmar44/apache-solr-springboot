package com.postgresdata.repository.postgresql;

import com.postgresdata.model.postgresql.DetailedProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailedProfileRepository extends JpaRepository<DetailedProfile,Long> {
}
