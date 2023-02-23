package com.hashedin.broadcast.searchengine.sql.service;

import com.hashedin.broadcast.searchengine.sql.model.CertifiedHashersSummary;
import com.hashedin.broadcast.searchengine.sql.model.Hasher;
import com.hashedin.broadcast.searchengine.sql.repository.CertifiedHashersSummaryRepository;
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

        certifiedHashersSummary.getHashersCertified().forEach(hasher -> hashers.add(hasherService.saveHasher(hasher)));
        certifiedHashersSummary.setHashersCertified(hashers);

        return certifiedHashersSummaryRepository.save(certifiedHashersSummary);
    }
}
