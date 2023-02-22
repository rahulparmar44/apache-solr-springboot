package com.searchengine.solr.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchengine.solr.Model.Certification.Root;
import com.searchengine.solr.Model.CountObj;
import com.searchengine.solr.Service.SolrCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dna/certifications")
public class SolrCertificationController {

    @Autowired
    SolrCertificateService solrCertificateService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("get-certificates-by-name")
    List<Root> getCertificatesByName(@RequestParam String name)  {
        return solrCertificateService.getCertificatesByName(name);
    }

    @RequestMapping("get-hashers-count")
    ResponseEntity<String> getCertifiedHasher(@RequestParam String name) throws IOException {
       String count = solrCertificateService.getCertifiedHashersCount(name);
        return  new ResponseEntity<String>(count,HttpStatus.OK);
    }

    @GetMapping("/get-count")
    public ResponseEntity<List<CountObj>> getAllCertificateCount(){
        return new ResponseEntity<>(solrCertificateService.getAllCertificateCount(),HttpStatus.OK) ;
    }

}
