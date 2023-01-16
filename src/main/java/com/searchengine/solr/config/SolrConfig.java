package com.searchengine.solr.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class SolrConfig {

    @Bean
    public CloudSolrClient solrClient() {
        //return new CloudSolrClient().Builder("http://localhost:9983/").build();
        final List<String> zkServers = new ArrayList<>();
        zkServers.add("localhost:9983");
        return new CloudSolrClient.Builder(zkServers, Optional.empty()).build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient client) throws Exception {
        return new SolrTemplate(client);
    }
}
