package com.hashedin.broadcast.searchengine.sql.repository;

import com.hashedin.broadcast.searchengine.sql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
