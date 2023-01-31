package com.searchengine.solr.Controller;

import com.searchengine.solr.Model.Certificates.Certificate;
import com.searchengine.solr.Service.ServiceImpl.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dna/certificates")
public class CertificateController {

    @Autowired
    CertificateService certificateService;

    @RequestMapping("get-certificates-by-name")
    List<Certificate> getCertificatesByName(@RequestParam String name){
        return  certificateService.getCertificatesByName(name);
    }


}
