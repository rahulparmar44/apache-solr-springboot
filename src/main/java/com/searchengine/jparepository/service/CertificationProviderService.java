package com.searchengine.jparepository.service;

import com.searchengine.jparepository.model.CertificationProvider;
import com.searchengine.jparepository.repository.CertificationProviderRepository;
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
