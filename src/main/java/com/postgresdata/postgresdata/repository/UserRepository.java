package com.postgresdata.postgresdata.repository;

import com.postgresdata.postgresdata.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
