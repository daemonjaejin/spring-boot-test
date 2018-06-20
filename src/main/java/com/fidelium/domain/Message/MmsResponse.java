package com.fidelium.domain.Message;

/**
 * Created by Administrator on 2017-11-30.
 */
public class MmsResponse {

    public MmsResponse(){

    }

    public MmsResponse(String messageId, String to){
        this.messageId = messageId;
        this.to = to;
    }

    private String messageId;

    private String to;

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

    @Override public String toString() {
        return "MmsResponse{" +
                "messageId='" + messageId + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
