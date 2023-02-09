package com.postgresdata.postgresdata.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.postgresdata.postgresdata.model.Certification;
import com.postgresdata.postgresdata.repository.CertificateRepository;
import com.postgresdata.postgresdata.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CertificateRepository certificateRepository;

//    @GetMapping("/certificates")
//    public ResponseEntity<String> exportCertificates1() {
//        List<Certification> certificates = certificateRepository.findAll();
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String json;
//        try {
//            json = objectMapper.writeValueAsString(certificates).replaceAll("^id$", "Id");
//        } catch (JsonProcessingException e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        return new ResponseEntity<>(json, HttpStatus.OK);
//    }

    @Autowired
    private ExportService exportService;

    @GetMapping("/certificates")
    public ResponseEntity<Boolean> exportCertificates() {
        List<Certification> certificates = certificateRepository.findAll();

        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        try {
            json = objectMapper.writeValueAsString(certificates).replaceAll("^id$", "Id");
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        boolean saved = false;
        try {
            File file = new File("output.json");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(json);
            fileWriter.close();
            saved = exportService.sendFileToSolr(file);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok().body(saved);
    }
}
