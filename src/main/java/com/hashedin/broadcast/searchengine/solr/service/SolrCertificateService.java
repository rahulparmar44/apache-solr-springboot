package com.hashedin.broadcast.searchengine.solr.service;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.hashedin.broadcast.searchengine.solr.model.certification.Certificate;
import com.hashedin.broadcast.searchengine.solr.model.CountObj;

import java.io.IOException;
import java.util.List;

public interface SolrCertificateService {
    List<Certificate> getCertificatesByName(String name) ;
    public String getCertifiedHashersCount(String name) throws IOException;

    List<CountObj> getAllCertificateCount() throws JacksonException;
}
