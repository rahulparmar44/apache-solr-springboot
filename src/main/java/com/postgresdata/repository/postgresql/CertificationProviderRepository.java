package com.postgresdata.repository.postgresql;

import com.postgresdata.model.postgresql.CertificationProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationProviderRepository extends JpaRepository<CertificationProvider, Long>{
    
}
