package com.postgresdata.repository.postgresql;

import com.postgresdata.model.postgresql.CertifiedHashersSummary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertifiedHashersSummaryRepository extends JpaRepository<CertifiedHashersSummary,Long> {
}
