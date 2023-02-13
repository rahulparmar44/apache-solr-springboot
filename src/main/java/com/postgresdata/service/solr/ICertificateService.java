package com.postgresdata.service.solr;



import com.postgresdata.model.solr.dna.Root;

import java.io.IOException;
import java.util.List;


public interface ICertificateService {
    List<Root> getCertificatesByName(String name) throws IOException;
    public String getCertifiedHashersCount(String name) throws IOException;
}
