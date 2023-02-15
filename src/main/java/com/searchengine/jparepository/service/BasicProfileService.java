package com.searchengine.jparepository.service;

import com.searchengine.jparepository.model.BasicProfile;
import com.searchengine.jparepository.repository.BasicProfileRepository;
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
