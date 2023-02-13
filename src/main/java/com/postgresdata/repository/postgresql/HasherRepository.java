package com.postgresdata.repository.postgresql;

import com.postgresdata.model.postgresql.Hasher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HasherRepository extends JpaRepository<Hasher,Long> {
}
