package com.postgresdata.postgresdata.repository;

import com.postgresdata.postgresdata.model.Capability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapabilityRepository extends JpaRepository<Capability,Long> {
}
