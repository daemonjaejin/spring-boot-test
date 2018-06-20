package com.fidelium.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017-10-26.
 */
public class Result<T> implements Serializable{

    private static final long serialVersionUID = -8227415535035645469L;

    public Result(){

    }

    public Result(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    private List<T> list;

    private T object;

    public String title;
    public String contents;

    private int totalNum;

    private int firstNum;

    private int lastNum;

    private boolean isCount;

    private List<User> userList;

    private List<CoinInfo> coinInfoList;

    private List<UserTradeHistory> userTradeHistoryList;

    private List<TradeHistory> tradeHistoryList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getLastNum() {
        return lastNum;
    }

    public void setLastNum(int lastNum) {
        this.lastNum = lastNum;
    }

    public boolean isCount() {
        return isCount;
    }

    public void setCount(boolean isCount) {
        this.isCount = isCount;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<CoinInfo> getCoinInfoList() {
        return coinInfoList;
    }

    public void setCoinInfoList(List<CoinInfo> coinInfoList) {
        this.coinInfoList = coinInfoList;
    }

    public List<UserTradeHistory> getUserTradeHistoryList() {
        return userTradeHistoryList;
    }

    public void setUserTradeHistoryList(List<UserTradeHistory> userTradeHistoryList) {
        this.userTradeHistoryList = userTradeHistoryList;
    }

    public List<TradeHistory> getTradeHistoryList() {
        return tradeHistoryList;
    }

    public void setTradeHistoryList(List<TradeHistory> tradeHistoryList) {
        this.tradeHistoryList = tradeHistoryList;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Result{" +
                "list=" + list +
                ", object=" + object +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", totalNum=" + totalNum +
                ", firstNum=" + firstNum +
                ", lastNum=" + lastNum +
                ", isCount=" + isCount +
                ", userList=" + userList +
                ", coinInfoList=" + coinInfoList +
                ", userTradeHistoryList=" + userTradeHistoryList +
                ", tradeHistoryList=" + tradeHistoryList +
                '}';
    }
}
