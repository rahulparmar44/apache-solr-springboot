package com.postgresdata.service.postgresql;


import com.postgresdata.model.postgresql.BasicProfile;
import com.postgresdata.model.postgresql.User;
import com.postgresdata.repository.postgresql.UserRepository;
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
