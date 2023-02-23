package com.hashedin.broadcast.searchengine.solr.controller;

import com.fasterxml.jackson.core.JacksonException;
import com.hashedin.broadcast.searchengine.solr.model.certification.Certificate;
import com.hashedin.broadcast.searchengine.solr.model.CountObj;
import com.hashedin.broadcast.searchengine.solr.service.SolrCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/dna/certifications")
public class CertificationController {

    @Autowired
    SolrCertificateService solrCertificateService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("get-certificates-by-name")
    List<Certificate> getCertificatesByName(@RequestParam String name)  {
        return solrCertificateService.getCertificatesByName(name);
    }

    @RequestMapping("get-hashers-count")
    ResponseEntity<String> getCertifiedHasher(@RequestParam String name) throws IOException {
       String count = solrCertificateService.getCertifiedHashersCount(name);
        return  new ResponseEntity<>(count,HttpStatus.OK);
    }

    @GetMapping("/get-count")
    public ResponseEntity<List<CountObj>> getAllCertificateCount() throws JacksonException {
        return new ResponseEntity<>(solrCertificateService.getAllCertificateCount(), HttpStatus.OK);
    }

}
