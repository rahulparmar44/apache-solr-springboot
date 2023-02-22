package com.hashedin.broadcast.searchengine.sql.repository;

import com.hashedin.broadcast.searchengine.sql.model.Hasher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HasherRepository extends JpaRepository<Hasher,Long> {
}
