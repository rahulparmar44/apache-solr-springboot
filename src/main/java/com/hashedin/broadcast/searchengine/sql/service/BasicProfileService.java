package com.hashedin.broadcast.searchengine.sql.service;

import com.hashedin.broadcast.searchengine.sql.model.BasicProfile;
import com.hashedin.broadcast.searchengine.sql.repository.BasicProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicProfileService {

    @Autowired
    BasicProfileRepository basicProfileRepository;

    public BasicProfile saveBasicProfile(BasicProfile basicProfile){
        return basicProfileRepository.save(basicProfile);
    }
}
