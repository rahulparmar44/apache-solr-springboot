package com.postgresdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableSolrRepositories(
		basePackages = "com.postgresdata.repository.solr.repository")
public class PostgresdataApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresdataApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
