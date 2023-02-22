package com.hashedin.broadcast.searchengine.solr.repository;

import com.hashedin.broadcast.searchengine.solr.model.certification.Certificate;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface SolrCertificateRepository extends SolrCrudRepository<Certificate, ArrayList<Integer>> {
    List<Certificate> findByName(String name);
}
