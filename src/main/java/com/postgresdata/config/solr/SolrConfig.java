package com.postgresdata.config.solr;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
//@CompileStatic
@EnableAutoConfiguration(exclude = org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration.class)
public class SolrConfig  {

    @Bean
    public CloudSolrClient solrClient() {
        final List<String> zkServers = new ArrayList<>();
        zkServers.add("localhost:9984");
        return new CloudSolrClient.Builder(zkServers, Optional.empty()).build();
    }
}
