package com.postgresdata.postgresdata.service;

import com.postgresdata.postgresdata.model.CertificationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresdata.postgresdata.repository.CertificationProviderRepository;

@Service

public class CertificationProviderService {

    @Autowired
    CertificationProviderRepository certificationProviderRepository;

    public CertificationProvider save(CertificationProvider certificationProvider) {

        return certificationProviderRepository.save(certificationProvider);

    }
    
}
