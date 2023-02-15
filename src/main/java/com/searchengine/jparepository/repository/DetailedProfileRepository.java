package com.searchengine.jparepository.repository;

import com.searchengine.jparepository.model.DetailedProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailedProfileRepository extends JpaRepository<DetailedProfile,Long> {
}
