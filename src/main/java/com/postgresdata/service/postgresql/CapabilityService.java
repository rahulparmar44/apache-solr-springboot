package com.postgresdata.service.postgresql;

import com.postgresdata.model.postgresql.Capability;
import com.postgresdata.repository.postgresql.CapabilityRepository;
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
