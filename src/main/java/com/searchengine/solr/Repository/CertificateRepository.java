package com.searchengine.solr.Repository;

import com.searchengine.solr.Model.Certificates.Certificate;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificateRepository extends SolrCrudRepository<Certificate, String> {
    List<Certificate> findByName(String name);
}
