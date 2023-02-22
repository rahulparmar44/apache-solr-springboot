package com.hashedin.broadcast.searchengine.sql.service;

import com.hashedin.broadcast.searchengine.sql.model.Hasher;
import com.hashedin.broadcast.searchengine.sql.repository.HasherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HasherService {

    @Autowired
    HasherRepository hasherRepository;

    @Autowired
    DetailedProfileService detailedProfileService;

    @Autowired
    BasicProfileService basicProfileService;

    public Hasher saveHasher(Hasher hasher){

        hasher.setDetailedProfile(detailedProfileService.saveDetailedProfile(hasher.getDetailedProfile()));
        hasher.setBasicProfile(basicProfileService.saveBasicProfile(hasher.getBasicProfile()));
        return hasherRepository.save(hasher);
    }
}
