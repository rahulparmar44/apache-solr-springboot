package com.hashedin.broadcast.searchengine.sql.service;

import com.hashedin.broadcast.searchengine.sql.model.Capability;
import com.hashedin.broadcast.searchengine.sql.model.CertificateChampion;
import com.hashedin.broadcast.searchengine.sql.model.Certification;
import com.hashedin.broadcast.searchengine.sql.model.CertifiedHashersSummary;
import com.hashedin.broadcast.searchengine.sql.repository.CertificateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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
        certification.getCertificateChampions()
                .forEach(
                        certificateChampion ->
                                champions.add(certificateChampionService.saveCertificateChampion(certificateChampion))
                );

        certification.setCertificateChampions(champions);


        CertifiedHashersSummary certifiedHashersSummary = certifiedHashersSummaryService
                .saveCertifiedHashersSummary(certification.getCertifiedHashersSummary());

        certification.setCertifiedHashersSummary(certifiedHashersSummary);

        List<Capability> capabilities = new ArrayList<>();
        certification.getCapability().forEach(
                capability -> capabilities.add(capabilityService.saveCapability(capability))
        );

        certification.setCapability(capabilities);

        return certificateRepository.save(certification);
    }

    public List<Certification> getCertificate() {

        return certificateRepository.findAll();
    }


}
