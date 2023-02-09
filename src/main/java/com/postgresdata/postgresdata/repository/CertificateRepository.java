package com.postgresdata.postgresdata.repository;

import com.postgresdata.postgresdata.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CertificateRepository extends JpaRepository<Certification, Long> {
}
