package com.postgresdata.config.postgresql;

import lombok.Data;

@Data
public class CollectionConfig {
    private int numShards;
    private int replicationFactor;
    private String name;

    public String toJson() {
        return "{\"create\":{\"name\":\"" + name + "\",\"numShards\":" + numShards + ",\"replicationFactor\":" + replicationFactor + "}}";
    }
}