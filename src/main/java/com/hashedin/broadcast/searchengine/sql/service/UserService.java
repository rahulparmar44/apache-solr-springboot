package com.hashedin.broadcast.searchengine.sql.service;

import com.hashedin.broadcast.searchengine.sql.model.BasicProfile;
import com.hashedin.broadcast.searchengine.sql.model.User;
import com.hashedin.broadcast.searchengine.sql.repository.UserRepository;
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
