package com.postgresdata.service.postgresql;


import com.postgresdata.model.postgresql.DetailedProfile;
import com.postgresdata.repository.postgresql.DetailedProfileRepository;
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
