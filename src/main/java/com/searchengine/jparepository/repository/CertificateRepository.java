package com.searchengine.jparepository.repository;

import com.searchengine.jparepository.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CertificateRepository extends JpaRepository<Certification, Long> {
}
