package com.fidelium.domain.BlockCypher;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017-10-31.
 */
public class Limits {

    @JsonProperty(value = "api/day")
    private int apiDay;

    @JsonProperty(value = "api/hour")
    private int apiHour;

    @JsonProperty(value = "api/second")
    private int apiSecond;

    @JsonProperty(value = "confidenceHour")
    private int confidenceHour;

    @JsonProperty(value = "hooks")
    private int hooks;

    @JsonProperty(value = "hooks/hour")
    private int hooksHour;

    public int getApiDay() {
        return apiDay;
    }

    public void setApiDay(int apiDay) {
        this.apiDay = apiDay;
    }

    public int getApiHour() {
        return apiHour;
    }

    public void setApiHour(int apiHour) {
        this.apiHour = apiHour;
    }

    public int getApiSecond() {
        return apiSecond;
    }

    public void setApiSecond(int apiSecond) {
        this.apiSecond = apiSecond;
    }

    public int getConfidenceHour() {
        return confidenceHour;
    }

    public void setConfidenceHour(int confidenceHour) {
        this.confidenceHour = confidenceHour;
    }

    public int getHooks() {
        return hooks;
    }

    public void setHooks(int hooks) {
        this.hooks = hooks;
    }

    public int getHooksHour() {
        return hooksHour;
    }

    public void setHooksHour(int hooksHour) {
        this.hooksHour = hooksHour;
    }

    @Override public String toString() {
        return "BlockCypherLimits{" +
                "apiDay=" + apiDay +
                ", apiHour=" + apiHour +
                ", apiSecond=" + apiSecond +
                ", confidenceHour=" + confidenceHour +
                ", hooks=" + hooks +
                ", hooksHour=" + hooksHour +
                '}';
    }
}
