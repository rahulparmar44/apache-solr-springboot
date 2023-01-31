package com.searchengine.solr.Service.ServiceImpl;

import com.searchengine.solr.Model.Certificates.Certificate;
import com.searchengine.solr.Repository.CertificateRepository;
import com.searchengine.solr.Service.ICertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CertificateService implements ICertificateService {

    @Autowired
    CertificateRepository certificateRepository;

    @Override
    public List<Certificate> getCertificatesByName(String name) {
        return  certificateRepository.findByName(name);
    }
}
