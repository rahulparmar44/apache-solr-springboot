package com.searchengine.solr.Service;

import com.searchengine.solr.Model.Certificates.Certificate;

import java.util.List;

public interface ICertificateService {
    List<Certificate> getCertificatesByName(String name);
}
