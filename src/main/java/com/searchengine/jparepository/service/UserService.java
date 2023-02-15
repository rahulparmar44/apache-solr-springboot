package com.searchengine.jparepository.service;

import com.searchengine.jparepository.model.BasicProfile;
import com.searchengine.jparepository.model.User;
import com.searchengine.jparepository.repository.UserRepository;
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
