package com.searchengine.solr.Service;

import com.searchengine.solr.Model.Certificates.Certificate;
import com.searchengine.solr.Model.Certification.Root;
import com.searchengine.solr.Model.CountObj;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.List;

public interface SolrCertificateService {
    List<Root> getCertificatesByName(String name) ;
    public String getCertifiedHashersCount(String name) throws IOException;

    List<CountObj> getAllCertificateCount();
}
