package com.postgresdata.service.postgresql;

import com.postgresdata.model.postgresql.CertificationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresdata.repository.postgresql.CertificationProviderRepository;

@Service

public class CertificationProviderService {

    @Autowired
    CertificationProviderRepository certificationProviderRepository;

    public CertificationProvider save(CertificationProvider certificationProvider) {

        return certificationProviderRepository.save(certificationProvider);

    }
    
}
