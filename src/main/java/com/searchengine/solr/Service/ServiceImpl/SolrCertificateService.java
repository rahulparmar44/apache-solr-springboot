package com.searchengine.solr.Service.ServiceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.searchengine.solr.Model.Certification.Root;
import com.searchengine.solr.Model.CountObj;
import com.searchengine.solr.Repository.SolrCertificateRepository;
import com.searchengine.solr.Service.ICertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SolrCertificateService implements ICertificateService {

    @Autowired
    SolrCertificateRepository solrCertificateRepository;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Root> getCertificatesByName(String name) {

        List<Root> rootList = solrCertificateRepository.findByName(name);
        return rootList;
    }

    @Override
    public String getCertifiedHashersCount(String name) throws IOException {
        return null;
    }

    @Override
    public List<CountObj> getAllCertificateCount() {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HashMap<String, String> countMap = new HashMap<>();
        ArrayList<CountObj> finalResponse = new ArrayList<>();
        String url = "http://localhost:8984/solr/certifications/select?fl=count,id&indent=true&q.op=OR&q=id:*/certifiedHashersSummary" + "?" + "&rows=1000&useParams=";
        ResponseEntity<String> response = restTemplate.exchange(url,
                HttpMethod.GET, new HttpEntity<String>(headers), String.class);
        LinkedHashMap<String, String> l = new LinkedHashMap<>();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(response.getBody()).get("response").get("docs");
        } catch (Exception e) {
        }
        ArrayList<HashMap<HashMap<String, String>, HashMap<String, String>>> arrayList = objectMapper.convertValue(jsonNode, ArrayList.class);
        for (HashMap c : arrayList) {
            String id = Arrays.stream(c.get("id").toString().split("/")).collect(Collectors.toList()).get(0);
            String uri = "http://localhost:8984/solr/certifications/select?fl=name&indent=true&q.op=OR&q=id:" + id + "&useParams=";
            ResponseEntity<String> nameResponse = restTemplate.exchange(uri,
                    HttpMethod.GET, new HttpEntity<String>(headers), String.class);
            JsonNode jsonNode1 = null;
            try {
                jsonNode1 = objectMapper.readTree(nameResponse.getBody()).get("response").get("docs");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            ArrayList<HashMap<String, ArrayList<String>>> names = objectMapper.convertValue(jsonNode1, ArrayList.class);
            String count = objectMapper.convertValue(c.get("count"), ArrayList.class).get(0).toString();
            CountObj countObj = new CountObj();
            countObj.setName(names.get(0).get("name").get(0));
            countObj.setCount(Integer.parseInt(count));
            finalResponse.add(countObj);
        }
        Collections.sort(finalResponse, new Comparator<CountObj>() {
            @Override
            public int compare(CountObj c1, CountObj c2) {
                if (c1.getCount() < c2.getCount())
                    return 1;
                else if (c1.getCount() == c2.getCount())
                    return 0;
                else
                    return -1;
            }
        });
        return finalResponse;
    }


//    @Autowired
//    public List<Root> findAllFields(String fields) {
//        return certificateRepository.findAllFields(fields);
//    }
}
