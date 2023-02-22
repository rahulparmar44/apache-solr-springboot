package com.hashedin.broadcast.searchengine.solr.model.certification;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "certifications")
public class Certificate {
        @Field
        public List<Integer> certId;
        @Field
        public List<String> name;
        @Field
        public List<String> description;
        @Field
        public List<Integer> level;
        @Field
        public List<Integer> valIdity;
        @Field
        public List<String> certificationType;
        @Field
        public List<Boolean> isPublished;
        @Field
        public List<Integer> durationInWeeks;
        @Field
        public List<String> __typename;
        @Field
        public String id;
        @Field
        public long _version_;
        @Field
        public String _root_;

        public List<String> getName() {
                return name;
        }

        public List<String> getDescription() {
                return description;
        }

        public List<Integer> getLevel() {
                return level;
        }

        public List<Integer> getValIdity() {
                return valIdity;
        }

        public List<String> getCertificationType() {
                return certificationType;
        }

        public List<Boolean> getIsPublished() {
                return isPublished;
        }

        public List<Integer> getDurationInWeeks() {
                return durationInWeeks;
        }

        public List<String> get__typename() {
                return __typename;
        }

        public long get_version_() {
                return _version_;
        }

        public String get_root_() {
                return _root_;
        }
}
