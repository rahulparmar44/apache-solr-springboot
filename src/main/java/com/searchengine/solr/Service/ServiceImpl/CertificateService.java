package com.searchengine.solr.Service.ServiceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchengine.solr.Model.Certification.Root;
import com.searchengine.solr.Repository.CertificateRepository;
import com.searchengine.solr.Service.ICertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CertificateService implements ICertificateService {

    @Autowired
    CertificateRepository certificateRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Root> getCertificatesByName(String name) {

        RestTemplate restTemplate = new RestTemplate();

        List<Root> rootList = certificateRepository.findByName(name);
        return rootList;
    }

    @Override
    public String getCertifiedHashersCount(String name) throws IOException {

        return null;
    }

    @Override

    public List<HashMap<String, String>> getAllCertificateCount()  {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HashMap<String,String> countMap = new HashMap<>();
        ArrayList<HashMap<String,String>> finalResponse = new ArrayList<>();
        String url = "http://localhost:8983/solr/certifications/select?fl=count,id&indent=true&q.op=OR&q=id:*/certifiedHashersSummary"+"?"+"&rows=1000&useParams=";
        ResponseEntity<String> response = restTemplate.exchange(url,
                HttpMethod.GET, new HttpEntity<String>(headers), String.class);
        LinkedHashMap<String,String> l = new LinkedHashMap<>();
        JsonNode jsonNode = null;
        try {
             jsonNode = objectMapper.readTree(response.getBody()).get("response").get("docs");
        }catch (Exception e){
        }
        ArrayList<HashMap<HashMap<String,String>,HashMap<String,String>>> arrayList = objectMapper.convertValue(jsonNode, ArrayList.class);
        for (HashMap c :arrayList){
            String id = Arrays.stream(c.get("id").toString().split("/")).collect(Collectors.toList()).get(0);
            String uri = "http://localhost:8983/solr/certifications/select?fl=name&indent=true&q.op=OR&q=id:"+id+"&useParams=";
            ResponseEntity<String> nameResponse = restTemplate.exchange(uri,
                    HttpMethod.GET, new HttpEntity<String>(headers), String.class);
            JsonNode jsonNode1 =  null;
            try {
                jsonNode1 = objectMapper.readTree(nameResponse.getBody()).get("response").get("docs");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            ArrayList<HashMap<String,ArrayList<String>>> names =  objectMapper.convertValue(jsonNode1, ArrayList.class);
            String count =  objectMapper.convertValue(c.get("count"),ArrayList.class).get(0).toString();
            HashMap<String,String> obj = new HashMap<>();
            obj.put("name",names.get(0).get("name").toString());
            obj.put("count",count);
            finalResponse.add(obj);
        }
        return finalResponse;
    }


}
