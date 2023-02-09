package com.postgresdata.postgresdata.service;


import com.postgresdata.postgresdata.model.DetailedProfile;
import com.postgresdata.postgresdata.repository.DetailedProfileRepository;
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
