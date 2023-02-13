package com.postgresdata.repository.solr.repository;

import com.postgresdata.model.solr.dna.Root;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("SolrCertificateRepository")
public interface SolrCertificateRepository extends SolrCrudRepository<Root, ArrayList<Integer>> {
    List<Root> findByName(String name);
//    @Query("id:7cfbcf27-3fd9-4200-9d69-d28249c86c03*&fl=?0")
//    List<Root> findAllFields(String fields);
}
