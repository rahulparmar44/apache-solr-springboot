package com.hashedin.broadcast.searchengine.sql.service;

import com.hashedin.broadcast.searchengine.sql.model.CertificateChampion;
import com.hashedin.broadcast.searchengine.sql.repository.CertificateChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
