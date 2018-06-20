package com.fidelium.domain;

public class UserTradeHistory extends Result {

    private String id;

    private String type;

    private String userTradeDatetime;

    private String kind;

    private String address;

    private Integer amount;

    private Double price;

    private Double rate;

    private Double charge;

    private String viewYn;

    private String qrPath;

    private String updDatetime;

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

    public String getUserTradeDatetime() {
        return userTradeDatetime;
    }

    public void setUserTradeDatetime(String userTradeDatetime) {
        this.userTradeDatetime = userTradeDatetime;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public String getQrPath() {
        return qrPath;
    }

    public void setQrPath(String qrPath) {
        this.qrPath = qrPath;
    }

    public String getUpdDatetime() {
        return updDatetime;
    }

    public void setUpdDatetime(String updDatetime) {
        this.updDatetime = updDatetime;
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
        return "UserTradeHistory{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", userTradeDatetime='" + userTradeDatetime + '\'' +
                ", kind='" + kind + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", rate=" + rate +
                ", charge=" + charge +
                ", viewYn='" + viewYn + '\'' +
                ", qrPath='" + qrPath + '\'' +
                ", updDatetime='" + updDatetime + '\'' +
                ", data='" + data + '\'' +
                ", txHash='" + txHash + '\'' +
                '}';
    }
}