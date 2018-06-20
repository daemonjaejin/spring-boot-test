package com.fidelium.domain.Message;

/**
 * Created by Administrator on 2017-12-01.
 */
public class Destinations {

    private String messageId;

    private String to;

    private String status;

    private String errorText;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    @Override public String toString() {
        return "Destinations{" +
                "messageId='" + messageId + '\'' +
                ", to='" + to + '\'' +
                ", status='" + status + '\'' +
                ", errorText='" + errorText + '\'' +
                '}';
    }
}
