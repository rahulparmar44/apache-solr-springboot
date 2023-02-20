package com.searchengine.solr.Controller;

import com.searchengine.solr.Model.Certification.Root;
import com.searchengine.solr.Service.ServiceImpl.SolrCertificateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/dna/certificates")
public class SolrCertificateController {

    @Autowired
    SolrCertificateServiceImpl solrCertificateServiceImpl;

    @RequestMapping("get-certificates-by-name")
    List<Root> getCertificatesByName(@RequestParam String name) throws IOException {
        return  solrCertificateServiceImpl.getCertificatesByName(name);
    }
}
