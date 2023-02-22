package com.hashedin.broadcast.searchengine.sql.repository;

import com.hashedin.broadcast.searchengine.sql.model.CertificationProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationProviderRepository extends JpaRepository<CertificationProvider, Long>{
    
}
