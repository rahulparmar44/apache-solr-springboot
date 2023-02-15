package com.searchengine.jparepository.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchengine.jparepository.model.Certification;
import com.searchengine.jparepository.repository.CertificateRepository;
import com.searchengine.jparepository.service.ExportService;
import com.searchengine.jparepository.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/export")
public class ExportController {

    @Value("${constants.solr.export_file_name}")
    public static  String EXPORT_FILE_NAME;
    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private ExportService exportService;

    @Autowired
    private JsonUtil jsonUtil;

    @GetMapping("/certificates")
    public ResponseEntity<Boolean> exportCertificates() {
        List<Certification> certificates = certificateRepository.findAll();

        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        try {
            json = jsonUtil.generateJson(certificates);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        boolean saved = false;
        try {
            File file = jsonUtil.generateFileFromJson(EXPORT_FILE_NAME, json);
            saved = exportService.sendFileToSolr(file);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok().body(saved);
    }
}
