package com.hashedin.broadcast.searchengine.solr.service.serviceimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hashedin.broadcast.searchengine.exception.SolrException;
import com.hashedin.broadcast.searchengine.solr.model.certification.Certificate;
import com.hashedin.broadcast.searchengine.solr.model.CountObj;
import com.hashedin.broadcast.searchengine.solr.repository.SolrCertificateRepository;
import com.hashedin.broadcast.searchengine.solr.service.SolrCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class SolrCertificateServiceImpl implements SolrCertificateService {

    public static final String SOLR_RESPONSE = "response";
    public static final String COUNT = "count";
    public static final String DOCS = "docs";
    @Autowired
    SolrCertificateRepository solrCertificateRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${solr.port}")
    private String solrPort;

    @Override
    public List<Certificate> getCertificatesByName(String name) {
        try {
            List<Certificate> certificateList = solrCertificateRepository.findByName(name);
            return certificateList;
        }
        catch (Exception e){
            if(e.getMessage().contains("Could not connect to ZooKeeper"))
                throw new SolrException("Zookeeper port not found, please provide correct zookeeper port",HttpStatus.BAD_REQUEST);
            else
                throw new SolrException("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
      
    }

    @Override
    public String getCertifiedHashersCount(String name) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Certificate> certificates = solrCertificateRepository.findByName(name);
        String rootId = "";
        for(Certificate certificate : certificates)
            rootId = certificate.get_root_();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        String url = solrPort+"/solr/certifications/select?q=id:"+rootId+"*&fl=count&rows=500";
        ResponseEntity<String> response = null ;
        try {
            response = restTemplate.exchange(url,
                    HttpMethod.GET, new HttpEntity<String>(headers), String.class);
        }catch (Exception e){
            if(e.getMessage().contains("Connection refused"))
                throw new SolrException("Solr port not found, please provide correct solr port",HttpStatus.BAD_REQUEST);
            else
                throw new SolrException("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        LinkedHashMap<String,String> l = new LinkedHashMap<>();
        JsonNode jsonNode = objectMapper.readTree(response.getBody()).get(SOLR_RESPONSE).get(DOCS);
        ArrayList<HashMap<String,List<Integer>>> arrayList = objectMapper.convertValue(jsonNode, ArrayList.class);
        Integer count = arrayList.stream().filter(e -> !e.isEmpty()).filter(e -> e.containsKey(COUNT)).collect(Collectors.toList()).get(0).get(COUNT).get(0);
        String hashersCount = "Number of certified hashers : "+ count.toString();
        return hashersCount;
    }

    @Override
    public List<CountObj> getAllCertificateCount() {
        ObjectMapper objectMapper = new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HashMap<String, String> countMap = new HashMap<>();
        ArrayList<CountObj> finalResponse = new ArrayList<>();
        String url = solrPort+"/solr/certifications/select?fl=count,id&indent=true&q.op=OR&q=id:*/certifiedHashersSummary" + "?" + "&rows=1000&useParams=";
        ResponseEntity<String> response = null ;
        try {
            response = restTemplate.exchange(url,
                    HttpMethod.GET, new HttpEntity<String>(headers), String.class);
        }catch (Exception e){
            if(e.getMessage().contains("Connection refused"))
                throw new SolrException("Solr port not found, please provide correct solr port",HttpStatus.BAD_REQUEST);
            else
                throw new SolrException("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        LinkedHashMap<String, String> l = new LinkedHashMap<>();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(response.getBody()).get(SOLR_RESPONSE).get("docs");
        } catch (Exception e) {
            throw new SolrException("Json pasring error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ArrayList<HashMap<HashMap<String, String>, HashMap<String, String>>> arrayList = objectMapper.convertValue(jsonNode, ArrayList.class);
        for (HashMap c : arrayList) {
            String id = Arrays.stream(c.get("id").toString().split("/")).collect(Collectors.toList()).get(0);
            String uri = solrPort+"/solr/certifications/select?fl=name&indent=true&q.op=OR&q=id:" + id + "&useParams=";
            ResponseEntity<String> nameResponse = null;
            try {
                nameResponse = restTemplate.exchange(uri,
                        HttpMethod.GET, new HttpEntity<String>(headers), String.class);
            }catch (Exception e){
                if(e.getMessage().contains("Connection refused"))
                    throw new SolrException("Solr port not found, please provide correct solr port",HttpStatus.BAD_REQUEST);
                else
                    throw new SolrException("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
            }
            JsonNode namesNode = null;
            try {
                namesNode = objectMapper.readTree(nameResponse.getBody()).get(SOLR_RESPONSE).get("docs");
            } catch (JsonProcessingException e) {
                throw new SolrException("Json parsing error",HttpStatus.INTERNAL_SERVER_ERROR);
            }
            ArrayList<HashMap<String, ArrayList<String>>> names = objectMapper.convertValue(namesNode, ArrayList.class);
            String count = objectMapper.convertValue(c.get("count"), ArrayList.class).get(0).toString();
            //String count = c.get("count").toString();
            CountObj countObj = new CountObj();
            if(names.size()!=0) {
                countObj.setName(names.get(0).get("name").get(0));
                countObj.setCount(Integer.parseInt(count));
                finalResponse.add(countObj);
            }
        }
        return sortCounts(finalResponse);
    }

    ArrayList<CountObj> sortCounts(ArrayList<CountObj> countObjs){
        Collections.sort(countObjs, new Comparator<CountObj>() {
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
        return countObjs ;
    }

}
