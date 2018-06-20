package com.fidelium.domain;

public class TradeHistory extends Result {

    public TradeHistory(){

    }

    public  TradeHistory(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    private String id;

    private String type;

    private String tradeDatetime;

    private String tradeType;

    private String sellBuyType;

    private Integer amount;

    private Double price;

    private Double rate;

    private Double dollarRate;

    private String syncStatus;

    private String updDatetime;

    private String status;

    private String viewYn;

    private String data;

    private String txHash;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTradeDatetime() {
        return tradeDatetime;
    }

    public void setTradeDatetime(String tradeDatetime) {
        this.tradeDatetime = tradeDatetime;
    }

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

    public String getSyncStatus() {
        return syncStatus;
    }

    public void setSyncStatus(String syncStatus) {
        this.syncStatus = syncStatus;
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
        return "TradeHistory{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", tradeDatetime='" + tradeDatetime + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", sellBuyType='" + sellBuyType + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", rate=" + rate +
                ", dollarRate=" + dollarRate +
                ", syncStatus='" + syncStatus + '\'' +
                ", updDatetime='" + updDatetime + '\'' +
                ", status='" + status + '\'' +
                ", viewYn='" + viewYn + '\'' +
                ", data='" + data + '\'' +
                ", txHash='" + txHash + '\'' +
                '}';
    }
}