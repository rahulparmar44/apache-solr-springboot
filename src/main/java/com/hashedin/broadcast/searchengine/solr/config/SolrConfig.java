package com.hashedin.broadcast.searchengine.solr.config;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class SolrConfig {
    @Value("${zookeeper.port}")
    private String zookeeperPort;

    @Bean
    public CloudSolrClient solrClient() {
        final List<String> zkServers = new ArrayList<>();
        zkServers.add(zookeeperPort);
        return new CloudSolrClient.Builder(zkServers, Optional.empty()).build();
    }

}
