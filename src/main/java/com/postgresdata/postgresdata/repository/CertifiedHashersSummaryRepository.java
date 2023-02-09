package com.postgresdata.postgresdata.repository;

import com.postgresdata.postgresdata.model.CertifiedHashersSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertifiedHashersSummaryRepository extends JpaRepository<CertifiedHashersSummary,Long> {
}
