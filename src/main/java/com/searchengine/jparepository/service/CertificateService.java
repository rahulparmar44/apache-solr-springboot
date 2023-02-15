package com.searchengine.jparepository.service;

import com.searchengine.jparepository.model.Capability;
import com.searchengine.jparepository.model.CertificateChampion;
import com.searchengine.jparepository.model.Certification;
import com.searchengine.jparepository.repository.CertificateRepository;
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
