package com.hashedin.broadcast.searchengine.solr.model.certification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HashersCertified {
    @Field
    public String id;
    @Field
    public DetailedProfile detailedProfile;
    @Field
    public BasicProfile basicProfile;
    @Field
    public String __typename;
}
