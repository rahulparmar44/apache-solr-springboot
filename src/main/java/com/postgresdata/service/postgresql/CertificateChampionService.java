package com.postgresdata.service.postgresql;

import com.postgresdata.model.postgresql.CertificateChampion;
import com.postgresdata.repository.postgresql.CertificateChampionRepository;
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
