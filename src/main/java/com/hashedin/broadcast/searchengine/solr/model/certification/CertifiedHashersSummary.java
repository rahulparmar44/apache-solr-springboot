package com.hashedin.broadcast.searchengine.solr.model.certification;

import org.apache.solr.client.solrj.beans.Field;

import java.util.ArrayList;

public class CertifiedHashersSummary{
    @Field
    public String id;
    @Field
    public ArrayList<HashersCertified> hashersCertified;
    @Field
    public int count;
    @Field
    public boolean isCertified;
    @Field
    public boolean isEnrolled;
    @Field
    public Object enrollment;
    @Field
    public String __typename;
}

