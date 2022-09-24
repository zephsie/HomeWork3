package com.zephie.jd2.classwork.core.entity;

import java.time.LocalDateTime;

public class Message {
    private long id;
    private String text;
    private String sender;
    private String recipient;
    private LocalDateTime date;

    public Message() {
    }

    public Message(long id, String text, String sender, String recipient, LocalDateTime date) {
        this.id = id;
        this.text = text;
        this.sender = sender;
        this.recipient = recipient;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
