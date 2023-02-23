package com.hashedin.broadcast.searchengine.solr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "filmJson")
public class Film {
    @Id
    @Field
    private String id;
    @Field("directed_by")
    private ArrayList<String> directedBy;
    @Field("initial_release_date")
    private ArrayList<Date> initialReleaseDate;
    @Field
    private ArrayList<String> genre;
    @Field
    private String name;
    @Field("_version_")
    private long version;
}
