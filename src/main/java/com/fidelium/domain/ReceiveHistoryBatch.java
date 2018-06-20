package com.fidelium.domain;

public class ReceiveHistoryBatch {

    private String id;

    private String type;

    private String orderDatetime;

    private String txHash;

    private String status;

    private Integer amount;

    private Double price;

    private Double rate;

    private String updDatetime;

    private String viewYn;

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

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column receive_history_batch.amount
     *
     * @param amount the value for receive_history_batch.amount
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column receive_history_batch.price
     *
     * @return the value of receive_history_batch.price
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column receive_history_batch.price
     *
     * @param price the value for receive_history_batch.price
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column receive_history_batch.rate
     *
     * @return the value of receive_history_batch.rate
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public Double getRate() {
        return rate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column receive_history_batch.rate
     *
     * @param rate the value for receive_history_batch.rate
     *
     * @mbg.generated Tue Nov 07 16:47:44 KST 2017
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getViewYn() {
        return viewYn;
    }

    public void setViewYn(String viewYn) {
        this.viewYn = viewYn;
    }

    public String getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(String orderDatetime) {
        this.orderDatetime = orderDatetime;
    }

    public String getUpdDatetime() {
        return updDatetime;
    }

    public void setUpdDatetime(String updDatetime) {
        this.updDatetime = updDatetime;
    }

    @Override public String toString() {
        return "ReceiveHistoryBatch{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", orderDatetime=" + orderDatetime +
                ", txHash='" + txHash + '\'' +
                ", status='" + status + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", rate=" + rate +
                ", updDatetime=" + updDatetime +
                ", viewYn='" + viewYn + '\'' +
                '}';
    }
}