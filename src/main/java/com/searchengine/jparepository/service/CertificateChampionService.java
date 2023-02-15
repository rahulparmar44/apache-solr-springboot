package com.searchengine.jparepository.service;

import com.searchengine.jparepository.model.CertificateChampion;
import com.searchengine.jparepository.repository.CertificateChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CertificateChampionService {

    @Autowired
    CertificateChampionRepository certificateChampionRepository;

    @Autowired
    UserService userService;

    public CertificateChampion saveCertificateChampion(CertificateChampion certificateChampion){

        certificateChampion.setUser(userService.saveUser(certificateChampion.getUser()));
        return certificateChampionRepository.save(certificateChampion);
    }

}
