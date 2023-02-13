package com.postgresdata.service.postgresql;


import com.postgresdata.model.postgresql.BasicProfile;
import com.postgresdata.repository.postgresql.BasicProfileRepository;
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
