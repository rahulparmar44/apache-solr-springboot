package com.hashedin.broadcast.searchengine.sql.service;

import com.hashedin.broadcast.searchengine.sql.model.DetailedProfile;
import com.hashedin.broadcast.searchengine.sql.repository.DetailedProfileRepository;
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
