package com.postgresdata.service.solr.ServiceImpl;



import com.postgresdata.model.solr.dna.Root;
import com.postgresdata.repository.solr.repository.SolrCertificateRepository;
import com.postgresdata.service.solr.ICertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class SolrCertificateService implements ICertificateService {

    @Autowired
    SolrCertificateRepository solrCertificateRepository;



    @Override
    public List<Root> getCertificatesByName(String name) {

        RestTemplate restTemplate = new RestTemplate();
        List<Root> rootList = new ArrayList<>();
        rootList = solrCertificateRepository.findByName(name);
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
