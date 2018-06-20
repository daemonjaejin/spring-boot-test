package com.fidelium.domain;

/**
 * Created by Administrator on 2017-12-05.
 */
public class RateInfo extends Result{

    public RateInfo(){

    }

    public RateInfo(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    private int keyValue;

    private Double sendRate;

    private Double tradeRate;

    private String updId;

    private String updDatetime;

    public Double getSendRate() {
        return sendRate;
    }

    public void setSendRate(Double sendRate) {
        this.sendRate = sendRate;
    }

    public Double getTradeRate() {
        return tradeRate;
    }

    public void setTradeRate(Double tradeRate) {
        this.tradeRate = tradeRate;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public String getUpdDatetime() {
        return updDatetime;
    }

    public void setUpdDatetime(String updDatetime) {
        this.updDatetime = updDatetime;
    }

    public int getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(int keyValue) {
        this.keyValue = keyValue;
    }

    @Override public String toString() {
        return "RateInfo{" +
                "keyValue=" + keyValue +
                ", sendRate=" + sendRate +
                ", tradeRate=" + tradeRate +
                ", updId='" + updId + '\'' +
                ", updDatetime='" + updDatetime + '\'' +
                '}';
    }
}
