package com.hashedin.broadcast.searchengine.sql.service;

import com.hashedin.broadcast.searchengine.sql.model.CertificationProvider;
import com.hashedin.broadcast.searchengine.sql.repository.CertificationProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class CertificationProviderService {

    @Autowired
    CertificationProviderRepository certificationProviderRepository;

    public CertificationProvider save(CertificationProvider certificationProvider) {

        return certificationProviderRepository.save(certificationProvider);

    }
    
}
