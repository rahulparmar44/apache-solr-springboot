package com.hashedin.broadcast.searchengine.solr.model.certification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedProfile {
    @Field
    public String id;
    @Field
    public String delEmail;
    @Field
    public String __typename;
}
