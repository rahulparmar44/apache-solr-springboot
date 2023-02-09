package com.postgresdata.postgresdata.service;

import com.postgresdata.postgresdata.model.Capability;
import com.postgresdata.postgresdata.repository.CapabilityRepository;
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
