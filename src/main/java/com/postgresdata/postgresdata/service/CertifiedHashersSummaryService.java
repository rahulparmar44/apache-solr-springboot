package com.postgresdata.postgresdata.service;

import com.postgresdata.postgresdata.model.CertifiedHashersSummary;
import com.postgresdata.postgresdata.model.Hasher;
import com.postgresdata.postgresdata.repository.CertifiedHashersSummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CertifiedHashersSummaryService {
    @Autowired
    CertifiedHashersSummaryRepository certifiedHashersSummaryRepository;

    @Autowired
    HasherService hasherService;


    public CertifiedHashersSummary saveCertifiedHashersSummary(CertifiedHashersSummary certifiedHashersSummary){
        List<Hasher> hashers = new ArrayList<>();
        for (Hasher h : certifiedHashersSummary.getHashersCertified()){
            hashers.add(hasherService.saveHasher(h));
        }
        certifiedHashersSummary.setHashersCertified(hashers);
        return certifiedHashersSummaryRepository.save(certifiedHashersSummary);
    }
}
