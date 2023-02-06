package com.searchengine.solr.Service;

import com.searchengine.solr.Model.Certificates.Certificate;
import com.searchengine.solr.Model.Certification.Root;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.List;

public interface ICertificateService {
    List<Root> getCertificatesByName(String name) throws IOException;
    public String getCertifiedHashersCount(String name) throws IOException;
}
