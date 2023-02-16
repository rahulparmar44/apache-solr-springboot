package com.searchengine.jparepository.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.searchengine.jparepository.model.Certification;
import com.searchengine.jparepository.service.CertificateService;
import com.searchengine.jparepository.service.CertificationProviderService;
import com.searchengine.jparepository.service.ExportService;
import com.searchengine.jparepository.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/certificate")
@Slf4j
public class CertificateController {

    @Autowired
    CertificateService certificateService;

    @Autowired
    CertificationProviderService certificationProviderService;

    @Autowired
    JsonUtil jsonUtil;

    @Autowired
    ExportService exportService;

    @PostMapping("/save")
    ResponseEntity<Optional<Certification>> saveCertificate(@RequestBody Certification certification) {
        certification = certificateService.saveCertificate(certification);

        try {
            String json = jsonUtil.generateJson(certification);
            File file = jsonUtil.generateFileFromJson("op.json", json);
            exportService.sendFileToSolr(file);
        } catch (JsonProcessingException e){
            log.error("json processing exception");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.empty());
        } catch (IOException e) {
            log.error("IO exception occurred");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Optional.empty());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(Optional.of(certification));
    }

    @GetMapping("/get")
    ResponseEntity<List<Certification>> getAllCertificates(){
        return  ResponseEntity.status(HttpStatus.CREATED).body(certificateService.getCertificate());
    }
}
