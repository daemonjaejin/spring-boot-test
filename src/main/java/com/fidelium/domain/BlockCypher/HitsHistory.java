package com.fidelium.domain.BlockCypher;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017-10-31.
 */
public class HitsHistory {

    @JsonProperty(value = "api/hour")
    private int apiHour;

    @JsonProperty(value = "time")
    private String time;

    public int getApiHour() {
        return apiHour;
    }

    public void setApiHour(int apiHour) {
        this.apiHour = apiHour;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override public String toString() {
        return "HitsHistory{" +
                "apiHour=" + apiHour +
                ", time='" + time + '\'' +
                '}';
    }
}
