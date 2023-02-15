package com.searchengine.jparepository.repository;

import com.searchengine.jparepository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
