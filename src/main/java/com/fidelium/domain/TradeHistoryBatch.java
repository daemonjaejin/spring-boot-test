package com.fidelium.domain;

import com.fidelium.domain2.TradeHistoryBatchKey;

public class TradeHistoryBatch extends TradeHistoryBatchKey {

    private String tradeType;

    private String sellBuyType;

    private Integer amount;

    private Double price;

    private Double rate;

    private Double dollarRate;

    private String updDatetime;

    private String status;

    private String viewYn;

    private String data;

    private String txHash;

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getSellBuyType() {
        return sellBuyType;
    }

    public void setSellBuyType(String sellBuyType) {
        this.sellBuyType = sellBuyType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getDollarRate() {
        return dollarRate;
    }

    public void setDollarRate(Double dollarRate) {
        this.dollarRate = dollarRate;
    }

    public String getUpdDatetime() {
        return updDatetime;
    }

    public void setUpdDatetime(String updDatetime) {
        this.updDatetime = updDatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getViewYn() {
        return viewYn;
    }

    public void setViewYn(String viewYn) {
        this.viewYn = viewYn;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    @Override
    public String toString() {
        return "TradeHistoryBatch{" +
                "tradeType='" + tradeType + '\'' +
                ", sellBuyType='" + sellBuyType + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", rate=" + rate +
                ", dollarRate=" + dollarRate +
                ", updDatetime='" + updDatetime + '\'' +
                ", status='" + status + '\'' +
                ", viewYn='" + viewYn + '\'' +
                ", data='" + data + '\'' +
                ", txHash='" + txHash + '\'' +
                '}';
    }
}