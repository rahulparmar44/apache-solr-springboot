package com.postgresdata.postgresdata.repository;

import com.postgresdata.postgresdata.model.DetailedProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailedProfileRepository extends JpaRepository<DetailedProfile,Long> {
}
