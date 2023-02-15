package com.searchengine.jparepository.service;

import com.searchengine.jparepository.model.Capability;
import com.searchengine.jparepository.repository.CapabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapabilityService {
    @Autowired
    CapabilityRepository capabilityRepository;

    public Capability saveCapability(Capability capability){
        return capabilityRepository.save(capability);
    }
}
