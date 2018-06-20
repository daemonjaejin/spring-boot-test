package com.fidelium.domain.BlockCypher;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017-10-31.
 */
public class Hits {

    @JsonProperty(value = "api/hour")
    private int apiHour;

    public int getApiHour() {
        return apiHour;
    }

    public void setApiHour(int apiHour) {
        this.apiHour = apiHour;
    }

    @Override public String toString() {
        return "BlockCypherHits{" +
                "apiHour=" + apiHour +
                '}';
    }
}
