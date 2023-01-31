package com.searchengine.solr.Model.Certificates;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasicProfile {
    @Field
    public String id;
    @Field
    public String name;
    @Field
    public String profilePic;
    @Field
    public String __typename;
}
