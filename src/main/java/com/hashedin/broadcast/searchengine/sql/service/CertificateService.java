package com.hashedin.broadcast.searchengine.sql.service;

import com.hashedin.broadcast.searchengine.sql.model.Capability;
import com.hashedin.broadcast.searchengine.sql.model.CertificateChampion;
import com.hashedin.broadcast.searchengine.sql.model.Certification;
import com.hashedin.broadcast.searchengine.sql.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CertificateService {

    @Autowired
    CertificateRepository certificateRepository;

    @Autowired
    CertificationProviderService certificationProviderService;

    @Autowired
    CertificateChampionService certificateChampionService;

    @Autowired
    CertifiedHashersSummaryService certifiedHashersSummaryService;

    @Autowired
    CapabilityService capabilityService;

    public Certification saveCertificate(Certification certification) {
        certification.setOfferedBy(certificationProviderService.save(certification.getOfferedBy()));
        List<CertificateChampion> champions = new ArrayList<>();
        for (CertificateChampion c :certification.getCertificateChampions()){
            champions.add(certificateChampionService.saveCertificateChampion(c));
        }
        certification.setCertificateChampions(champions);
        certifiedHashersSummaryService.saveCertifiedHashersSummary(certification.getCertifiedHashersSummary());
        List<Capability> capabilities = new ArrayList<>();
        for (Capability c : certification.getCapability()){
            capabilities.add(capabilityService.saveCapability(c));
        }
        certification.setCapability(capabilities);
        return certificateRepository.save(certification);
    }

    public List<Certification> getCertificate() {

        List<Certification> l = certificateRepository.findAll();
        return l;
    }


}
