package com.hashedin.broadcast.searchengine.sql.service;

import com.hashedin.broadcast.searchengine.sql.model.Capability;
import com.hashedin.broadcast.searchengine.sql.repository.CapabilityRepository;
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
