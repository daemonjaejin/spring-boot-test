package com.fidelium.domain;

/**
 * Created by Administrator on 2017-11-23.
 */
public class Board extends Result {

    public Board(){

    }

    public Board(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    private String id;

    private String adminId;

    private String subject;

    private String substance;

    private String insDatetime;

    private String updDatetime;

    private String delDatetime;

    private String delYn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubstance() {
        return substance;
    }

    public void setSubstance(String substance) {
        this.substance = substance;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public String getInsDatetime() {
        return insDatetime;
    }

    public void setInsDatetime(String insDatetime) {
        this.insDatetime = insDatetime;
    }

    public String getUpdDatetime() {
        return updDatetime;
    }

    public void setUpdDatetime(String updDatetime) {
        this.updDatetime = updDatetime;
    }

    public String getDelDatetime() {
        return delDatetime;
    }

    public void setDelDatetime(String delDatetime) {
        this.delDatetime = delDatetime;
    }

    @Override public String toString() {
        return "Board{" +
                "id='" + id + '\'' +
                ", adminId='" + adminId + '\'' +
                ", subject='" + subject + '\'' +
                ", substance='" + substance + '\'' +
                ", insDatetime=" + insDatetime +
                ", updDatetime=" + updDatetime +
                ", delDatetime=" + delDatetime +
                ", delYn='" + delYn + '\'' +
                '}';
    }
}
