package com.fidelium.domain.Message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017-11-30.
 */
public class MmsAuthToken {

    private int keyValue;

    @JsonProperty(value = "accessToken")
    private String accessToken;

    @JsonProperty(value = "schema")
    private String schemaValue;

    @JsonProperty(value = "expired")
    private String expired;

    @JsonIgnore
    private String insDatetime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public int getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(int keyValue) {
        this.keyValue = keyValue;
    }

    public String getSchemaValue() {
        return schemaValue;
    }

    public void setSchemaValue(String schemaValue) {
        this.schemaValue = schemaValue;
    }

    public String getInsDatetime() {
        return insDatetime;
    }

    public void setInsDatetime(String insDatetime) {
        this.insDatetime = insDatetime;
    }

    @Override public String toString() {
        return "MmsAuthToken{" +
                "keyValue=" + keyValue +
                ", accessToken='" + accessToken + '\'' +
                ", schemaValue='" + schemaValue + '\'' +
                ", expired='" + expired + '\'' +
                ", insDatetime='" + insDatetime + '\'' +
                '}';
    }
}
