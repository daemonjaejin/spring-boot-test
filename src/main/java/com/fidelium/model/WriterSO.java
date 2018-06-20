package com.fidelium.model;

/**
 * Created by Administrator on 2017-11-09.
 */
public class WriterSO {

    private long id;
    private String fullName;
    private String randomNum;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(String randomNum) {
        this.randomNum = randomNum;
    }

    @Override public String toString() {
        return "WriterSO{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", randomNum='" + randomNum + '\'' +
                '}';
    }
}
