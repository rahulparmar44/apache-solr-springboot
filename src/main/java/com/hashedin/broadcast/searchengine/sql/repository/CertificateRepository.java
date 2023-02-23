package com.hashedin.broadcast.searchengine.sql.repository;

import com.hashedin.broadcast.searchengine.sql.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CertificateRepository extends JpaRepository<Certification, Long> {
}
