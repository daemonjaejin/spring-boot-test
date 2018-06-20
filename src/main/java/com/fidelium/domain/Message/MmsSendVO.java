package com.fidelium.domain.Message;

import com.fidelium.domain.Result;

import java.util.List;

/**
 * Created by Administrator on 2017-11-30.
 */
public class MmsSendVO extends Result {

    public MmsSendVO(){

    }

    public MmsSendVO(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    private String messageId;

    private String messageType;

    private String requestTime;

    private String from;

    private String resultCode;

    private String errorText;

    private String reportTime;

    private String carrier;

    private String to;

    private String groupId;

    private String toCount;

    private List<Destinations> destinations;

    private String ref;

    private String status;

    private String insDatetime;

    private String mmsNum;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getToCount() {
        return toCount;
    }

    public void setToCount(String toCount) {
        this.toCount = toCount;
    }

    public List<Destinations> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destinations> destinations) {
        this.destinations = destinations;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInsDatetime() {
        return insDatetime;
    }

    public void setInsDatetime(String insDatetime) {
        this.insDatetime = insDatetime;
    }

    public String getMmsNum() {
        return mmsNum;
    }

    public void setMmsNum(String mmsNum) {
        this.mmsNum = mmsNum;
    }

    @Override public String toString() {
        return "MmsSendVO{" +
                "messageId='" + messageId + '\'' +
                ", messageType='" + messageType + '\'' +
                ", requestTime='" + requestTime + '\'' +
                ", from='" + from + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", errorText='" + errorText + '\'' +
                ", reportTime='" + reportTime + '\'' +
                ", carrier='" + carrier + '\'' +
                ", to='" + to + '\'' +
                ", groupId='" + groupId + '\'' +
                ", toCount='" + toCount + '\'' +
                ", destinations=" + destinations +
                ", ref='" + ref + '\'' +
                ", status='" + status + '\'' +
                ", insDatetime='" + insDatetime + '\'' +
                ", mmsNum='" + mmsNum + '\'' +
                '}';
    }
}
