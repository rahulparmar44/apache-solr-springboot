package com.hashedin.broadcast.searchengine.sql.controller;

import com.hashedin.broadcast.searchengine.sql.dto.CollectionConfig;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api2")
@Slf4j
class CollectionController {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Value("${constants.solr.url}")
    public static String SOLR_URL;


    private final OkHttpClient client = new OkHttpClient();

    @PostMapping("/collections")
    public ResponseEntity<String> createCollection(@RequestBody CollectionConfig config) throws Exception {

        log.info("coming");
        okhttp3.RequestBody body = okhttp3.RequestBody.create(
                config.toJson(),
                MediaType.get("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url(SOLR_URL + "/api/collections")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new Exception("Failed to create collection: " + response.body().string());
            }
        }

        return ResponseEntity.ok().body("done");

    }


}

