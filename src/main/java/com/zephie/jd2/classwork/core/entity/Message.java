package com.zephie.jd2.classwork.core.entity;

import java.util.Calendar;

public class Message {
    private long id;
    private String text;
    private String sender;
    private String recipient;
    private Calendar date;

    public Message(long id, String text, String sender, String recipient, Calendar date) {
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

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }
}
