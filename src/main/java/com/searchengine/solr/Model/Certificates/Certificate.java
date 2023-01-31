package com.searchengine.solr.Model.Certificates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "certificates")
public class Certificate {
    @Id
    @Field
    public String id;
    @Field
    public String name;
    @Field
    public String description;
    @Field
    public String level;
    @Field
    public int validity;
    @Field
    public OfferedBy offeredBy;
    @Field
    public String certificationType;
    @Field
    public ArrayList<Object> capability;
    @Field
    public ArrayList<CertificateChampion> certificateChampions;
    @Field
    public Object openForEnrollmentTill;
    @Field
    public boolean isPublished;
    @Field
    public int durationInWeeks;
    @Field
    public CertifiedHashersSummary certifiedHashersSummary;
    @Field
    public String __typename;
}
