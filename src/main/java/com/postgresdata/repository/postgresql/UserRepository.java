package com.postgresdata.repository.postgresql;

import com.postgresdata.model.postgresql.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
