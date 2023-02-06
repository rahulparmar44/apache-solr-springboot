package com.searchengine.solr.Model.Certification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.ArrayList;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "certifications")
public class Root {
        @Field
        public ArrayList<Integer> Id;
        @Field
        public ArrayList<String> name;
        @Field
        public ArrayList<String> description;
        @Field
        public ArrayList<Integer> level;
        @Field
        public ArrayList<Integer> valIdity;
        @Field
        public ArrayList<String> certificationType;
        @Field
        public ArrayList<Boolean> isPublished;
        @Field
        public ArrayList<Integer> durationInWeeks;
        @Field
        public ArrayList<String> __typename;
        @Field
        public String id;
        @Field
        public long _version_;
        @Field
        public String _root_;

        public ArrayList<String> getName() {
                return name;
        }

        public ArrayList<String> getDescription() {
                return description;
        }

        public ArrayList<Integer> getLevel() {
                return level;
        }

        public ArrayList<Integer> getValIdity() {
                return valIdity;
        }

        public ArrayList<String> getCertificationType() {
                return certificationType;
        }

        public ArrayList<Boolean> getIsPublished() {
                return isPublished;
        }

        public ArrayList<Integer> getDurationInWeeks() {
                return durationInWeeks;
        }

        public ArrayList<String> get__typename() {
                return __typename;
        }

        public long get_version_() {
                return _version_;
        }

        public String get_root_() {
                return _root_;
        }
}
