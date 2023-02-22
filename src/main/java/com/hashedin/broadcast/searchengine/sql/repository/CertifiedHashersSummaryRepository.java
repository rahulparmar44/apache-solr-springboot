package com.hashedin.broadcast.searchengine.sql.repository;

import com.hashedin.broadcast.searchengine.sql.model.CertifiedHashersSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertifiedHashersSummaryRepository extends JpaRepository<CertifiedHashersSummary,Long> {
}
