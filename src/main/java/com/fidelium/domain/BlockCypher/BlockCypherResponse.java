package com.fidelium.domain.BlockCypher;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Administrator on 2017-10-31.
 */
public class BlockCypherResponse {

    @JsonProperty(value = "token")
    private String token;

    @JsonProperty(value = "limits")
    private Limits limits;

    @JsonProperty(value = "hits")
    private Hits hits;

    @JsonProperty(value = "hits_history")
    private List<HitsHistory> hitsHistory;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Limits getLimits() {
        return limits;
    }

    public void setLimits(Limits limits) {
        this.limits = limits;
    }

    public Hits getHits() {
        return hits;
    }

    public void setHits(Hits hits) {
        this.hits = hits;
    }

    public List<HitsHistory> getHitsHistory() {
        return hitsHistory;
    }

    public void setHitsHistory(List<HitsHistory> hitsHistory) {
        this.hitsHistory = hitsHistory;
    }

    @Override public String toString() {
        return "BlockCypherResponse{" +
                "token='" + token + '\'' +
                ", limits=" + limits +
                ", hits=" + hits +
                ", hitsHistory=" + hitsHistory +
                '}';
    }
}
