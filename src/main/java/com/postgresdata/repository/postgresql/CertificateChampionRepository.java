package com.postgresdata.repository.postgresql;

import com.postgresdata.model.postgresql.CertificateChampion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateChampionRepository extends JpaRepository<CertificateChampion,Long> {
}
