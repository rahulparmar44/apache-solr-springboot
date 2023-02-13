package com.postgresdata.repository.postgresql;

import com.postgresdata.model.postgresql.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("CertificateRepository")
public interface CertificateRepository extends JpaRepository<Certification, Long> {
}
