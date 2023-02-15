package com.searchengine.jparepository.controller;

import com.searchengine.jparepository.model.Certification;
import com.searchengine.jparepository.service.CertificateService;
import com.searchengine.jparepository.service.CertificationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    CertificateService certificateService;

    @Autowired
    CertificationProviderService certificationProviderService;

    @PostMapping("/save")
    ResponseEntity<Certification> saveCertificate(@RequestBody Certification certification) {
        certification = certificateService.saveCertificate(certification);
        return ResponseEntity.status(HttpStatus.CREATED).body(certification);
    }

    @GetMapping("/get")
    ResponseEntity<List<Certification>> getAllCertificates(){
        return  ResponseEntity.status(HttpStatus.CREATED).body(certificateService.getCertificate());
    }
}
