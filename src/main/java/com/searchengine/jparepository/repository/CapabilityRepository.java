package com.searchengine.jparepository.repository;

import com.searchengine.jparepository.model.Capability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapabilityRepository extends JpaRepository<Capability,Long> {
}
