package com.postgresdata.service.postgresql;

import com.postgresdata.model.postgresql.CertifiedHashersSummary;
import com.postgresdata.model.postgresql.Hasher;
import com.postgresdata.repository.postgresql.CertifiedHashersSummaryRepository;
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
