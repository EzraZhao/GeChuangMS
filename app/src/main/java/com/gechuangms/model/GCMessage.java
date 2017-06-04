package com.gechuangms.model;

import org.litepal.crud.DataSupport;

/**
 * Created by Ezra on 2017/5/31.
 */

public class GCMessage extends DataSupport {

    private String messageTitle;
    private String messageContent;
    private int messageImageId;

    public GCMessage() {
    }

    public GCMessage(String messageTitle, String messageContent, int messageImageId) {
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.messageImageId = messageImageId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public int getMessageImageId() {
        return messageImageId;
    }

    public void setMessageImageId(int messageImageId) {
        this.messageImageId = messageImageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GCMessage gcMessage = (GCMessage) o;

        if (messageImageId != gcMessage.messageImageId) return false;
        if (messageTitle != null ? !messageTitle.equals(gcMessage.messageTitle) : gcMessage.messageTitle != null)
            return false;
        return messageContent != null ? messageContent.equals(gcMessage.messageContent) : gcMessage.messageContent == null;

    }

    @Override
    public int hashCode() {
        int result = messageTitle != null ? messageTitle.hashCode() : 0;
        result = 31 * result + (messageContent != null ? messageContent.hashCode() : 0);
        result = 31 * result + messageImageId;
        return result;
    }

    @Override
    public String toString() {
        return "GCMessage{" +
                "messageTitle='" + messageTitle + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageImageId=" + messageImageId +
                '}';
    }
}
