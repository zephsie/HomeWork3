package com.zephie.jd2.classwork.core.dto;

public class MessageDTO {
    private String text;
    private String sender;
    private String recipient;

    public MessageDTO() {
    }

    public MessageDTO(String text, String sender, String recipient) {
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
