package com.searchengine.jparepository.service;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
@Slf4j
public class ExportService {

    public static String SOLR_URL = "http://localhost:8984";

    public boolean sendFileToSolr(File file) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("","output.json",
                        RequestBody.create(file, MediaType.parse("application/json")))
                .build();

        Request request = new Request.Builder()
                .url(SOLR_URL+"/solr/certification/update?commitWithin=100&overwrite=false&wt=json")
                .method("POST", body)
                .build();

        Response response = client.newCall(request).execute();
        log.info(response.toString());
        log.info(Objects.requireNonNull(response.body()).string());
        return response.isSuccessful();

    }
}
