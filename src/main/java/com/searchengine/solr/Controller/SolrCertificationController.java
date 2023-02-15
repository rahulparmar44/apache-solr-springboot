package com.searchengine.solr.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchengine.solr.Model.Certification.Root;
import com.searchengine.solr.Model.CountObj;
import com.searchengine.solr.Service.ServiceImpl.SolrCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dna/certifications")
public class SolrCertificationController {

    @Autowired
    SolrCertificateService solrCertificateService;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("get-certificates-by-name")
    List<Root> getCertificatesByName(@RequestParam String name)  {
        List<Root>  rootList = solrCertificateService.getCertificatesByName(name);
        return rootList;
    }

    @RequestMapping("get-hashers-count")
    ResponseEntity<String> getCertifiedHasher(@RequestParam String name) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Root> roots = solrCertificateService.getCertificatesByName(name);
        String rootId = "";
        for(Root root : roots)
            rootId = root.get_root_();

        System.out.println("rootId ::::" + rootId);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String url = "http://localhost:8984/solr/certifications/select?q=id:"+rootId+"*&fl=count&rows=500";
        ResponseEntity<String> response = restTemplate.exchange(url,
                HttpMethod.GET, new HttpEntity<String>(headers), String.class);
        System.out.println(response.getBody());
        LinkedHashMap<String,String> l = new LinkedHashMap<>();

        JsonNode jsonNode = objectMapper.readTree(response.getBody()).get("response").get("docs");

        ArrayList<HashMap<String,List<Integer>>> arrayList = objectMapper.convertValue(jsonNode, ArrayList.class);
        Integer count = arrayList.stream().filter(e -> !e.isEmpty()).filter(e -> e.containsKey("count")).collect(Collectors.toList()).get(0).get("count").get(0);
        String out = "Number of certified hashers : "+ count.toString();
        return  new ResponseEntity<String>(out,HttpStatus.OK);
    }

    @GetMapping("/get-count")
    public ResponseEntity<List<CountObj>> getAllCertificateCount(){
        return new ResponseEntity<>(solrCertificateService.getAllCertificateCount(),HttpStatus.OK) ;
    }

}
