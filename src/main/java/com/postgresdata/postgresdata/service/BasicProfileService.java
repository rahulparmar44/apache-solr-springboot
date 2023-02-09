package com.postgresdata.postgresdata.service;


import com.postgresdata.postgresdata.model.BasicProfile;
import com.postgresdata.postgresdata.repository.BasicProfileRepository;
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
