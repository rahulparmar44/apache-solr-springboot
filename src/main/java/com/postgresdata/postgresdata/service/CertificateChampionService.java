package com.postgresdata.postgresdata.service;

import com.postgresdata.postgresdata.model.CertificateChampion;
import com.postgresdata.postgresdata.repository.CertificateChampionRepository;
import com.postgresdata.postgresdata.repository.CertificateRepository;
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
