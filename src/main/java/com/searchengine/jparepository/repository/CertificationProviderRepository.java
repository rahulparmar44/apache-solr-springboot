package com.searchengine.jparepository.repository;

import com.searchengine.jparepository.model.CertificationProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationProviderRepository extends JpaRepository<CertificationProvider, Long>{
    
}
