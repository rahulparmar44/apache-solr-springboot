package com.searchengine.solr.Service.ServiceImpl;

import com.searchengine.solr.Model.Certification.Root;
import com.searchengine.solr.Repository.CertificateRepository;
import com.searchengine.solr.Service.ICertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
@Service
public class CertificateService implements ICertificateService {

    @Autowired
    CertificateRepository certificateRepository;



    @Override
    public List<Root> getCertificatesByName(String name) {

        RestTemplate restTemplate = new RestTemplate();

        List<Root> rootList = certificateRepository.findByName(name);
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
