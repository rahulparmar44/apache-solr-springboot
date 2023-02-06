package com.searchengine.solr.Repository;

import com.searchengine.solr.Model.Certification.Root;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CertificateRepository extends SolrCrudRepository<Root, ArrayList<Integer>> {
    List<Root> findByName(String name);
//    @Query("id:7cfbcf27-3fd9-4200-9d69-d28249c86c03*&fl=?0")
//    List<Root> findAllFields(String fields);
}
