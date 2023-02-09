package com.postgresdata.postgresdata.service;


import com.postgresdata.postgresdata.model.BasicProfile;
import com.postgresdata.postgresdata.model.User;
import com.postgresdata.postgresdata.repository.BasicProfileRepository;
import com.postgresdata.postgresdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BasicProfileService basicProfileService;

    public User saveUser(User user){
        BasicProfile basicProfile = basicProfileService.saveBasicProfile(user.getBasicProfile());
        user.setBasicProfile(basicProfile);
        return userRepository.save(user);
    }
}
