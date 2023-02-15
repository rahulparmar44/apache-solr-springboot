package com.searchengine.jparepository.service;

import com.searchengine.jparepository.model.DetailedProfile;
import com.searchengine.jparepository.repository.DetailedProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailedProfileService {

    @Autowired
    DetailedProfileRepository detailedProfileRepository;

    public DetailedProfile saveDetailedProfile(DetailedProfile detailedProfile){
        return detailedProfileRepository.save(detailedProfile);
    }

}
