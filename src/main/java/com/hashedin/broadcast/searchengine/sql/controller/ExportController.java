package com.hashedin.broadcast.searchengine.sql.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hashedin.broadcast.searchengine.sql.model.Certification;
import com.hashedin.broadcast.searchengine.sql.repository.CertificateRepository;
import com.hashedin.broadcast.searchengine.sql.service.ExportService;
import com.hashedin.broadcast.searchengine.sql.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    private CertificateRepository certificateRepository;

    @Autowired
    private ExportService exportService;

    @Autowired
    private JsonUtil jsonUtil;

    @GetMapping("/certificates")
    public ResponseEntity<Boolean> exportCertificates() {
        List<Certification> certificates = certificateRepository.findAll();
        String json;
        try {
            json = jsonUtil.generateJson(certificates);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        boolean saved = false;
        try {
            File file = jsonUtil.generateFileFromJson("output.json", json);
            saved = exportService.sendFileToSolr(file);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok().body(saved);
    }
}
