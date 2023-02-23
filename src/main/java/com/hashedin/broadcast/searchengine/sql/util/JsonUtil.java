package com.hashedin.broadcast.searchengine.sql.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@Slf4j
@Component
public class JsonUtil {
    public String generateJson(Object certificates) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        try {
            json = objectMapper.writeValueAsString(certificates).replaceAll("\"id\"", "\"Id\"");
        } catch (JsonProcessingException e) {
            log.error("Json Processing Exception Occurred");
            throw e;
        }
        return json;
    }

    public File generateFileFromJson(String filename, String json) throws IOException {
        File file = new File(filename);
        try (FileWriter fileWriter = new FileWriter(file)){
            fileWriter.write(json);
        } catch (IOException e) {
            log.error("IO Exception Occurred");
            throw e;
        }
        return file;
    }
}
