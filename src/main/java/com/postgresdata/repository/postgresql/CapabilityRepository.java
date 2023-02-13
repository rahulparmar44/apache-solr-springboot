package com.postgresdata.repository.postgresql;

import com.postgresdata.model.postgresql.Capability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapabilityRepository extends JpaRepository<Capability,Long> {
}
