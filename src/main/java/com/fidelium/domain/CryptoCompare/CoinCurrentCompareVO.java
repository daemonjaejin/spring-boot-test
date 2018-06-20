package com.fidelium.domain.CryptoCompare;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fidelium.domain.Result;

import java.util.Arrays;

/**
 * Created by Administrator on 2017-11-24.
 */
public class CoinCurrentCompareVO extends Result {

    public CoinCurrentCompareVO(){

    }

    public CoinCurrentCompareVO(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    private String type;

    private String [] coinList;

    @JsonProperty(value = "BTC")
    private String btc;

    @JsonProperty(value = "ETH")
    private String eth;

    @JsonProperty(value = "LTC")
    private String ltc;

    @JsonProperty(value = "DASH")
    private String dash;

    @JsonProperty(value = "USD")
    private String usd;

    @JsonProperty(value = "KRW")
    private String krw;

    @JsonProperty(value = "EUR")
    private String eur;


    public String getBtc() {
        return btc;
    }

    public void setBtc(String btc) {
        this.btc = btc;
    }

    public String getEth() {
        return eth;
    }

    public void setEth(String eth) {
        this.eth = eth;
    }

    public String getLtc() {
        return ltc;
    }

    public void setLtc(String ltc) {
        this.ltc = ltc;
    }

    public String getDash() {
        return dash;
    }

    public void setDash(String dash) {
        this.dash = dash;
    }

    public String getUsd() {
        return usd;
    }

    public void setUsd(String usd) {
        this.usd = usd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getCoinList() {
        return coinList;
    }

    public void setCoinList(String[] coinList) {
        this.coinList = coinList;
    }

    public String getKrw() {
        return krw;
    }

    public void setKrw(String krw) {
        this.krw = krw;
    }

    public String getEur() {
        return eur;
    }

    public void setEur(String eur) {
        this.eur = eur;
    }

    @Override
    public String toString() {
        return "CoinCurrentCompareVO{" +
                "type='" + type + '\'' +
                ", coinList=" + Arrays.toString(coinList) +
                ", btc='" + btc + '\'' +
                ", eth='" + eth + '\'' +
                ", ltc='" + ltc + '\'' +
                ", dash='" + dash + '\'' +
                ", usd='" + usd + '\'' +
                ", krw='" + krw + '\'' +
                ", eur='" + eur + '\'' +
                '}';
    }
}
