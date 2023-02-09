package com.postgresdata.postgresdata.repository;

import com.postgresdata.postgresdata.model.CertificationProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresdata.postgresdata.model.OfferedBy;

@Repository
public interface CertificationProviderRepository extends JpaRepository<CertificationProvider, Long>{
    
}
