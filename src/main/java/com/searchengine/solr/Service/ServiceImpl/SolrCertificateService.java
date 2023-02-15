package com.searchengine.solr.Service.ServiceImpl;

import com.searchengine.solr.Model.Certification.Root;
import com.searchengine.solr.Repository.SolrCertificateRepository;
import com.searchengine.solr.Service.ICertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
@Service
public class SolrCertificateService implements ICertificateService {

    @Autowired
    SolrCertificateRepository solrCertificateRepository;



    @Override
    public List<Root> getCertificatesByName(String name) {

        RestTemplate restTemplate = new RestTemplate();

        List<Root> rootList = solrCertificateRepository.findByName(name);
        return rootList;
    }

    @Override
    public String getCertifiedHashersCount(String name) throws IOException {
        return null;
    }


//    @Autowired
//    public List<Root> findAllFields(String fields) {
//        return certificateRepository.findAllFields(fields);
//    }
}
