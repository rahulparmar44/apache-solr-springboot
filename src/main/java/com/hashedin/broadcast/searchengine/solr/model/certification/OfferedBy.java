package com.hashedin.broadcast.searchengine.solr.model.certification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfferedBy {
    @Field
    public String id;
    @Field
    public String name;
    @Field
    public String imageUrl;
    @Field
    public String __typename;
}
