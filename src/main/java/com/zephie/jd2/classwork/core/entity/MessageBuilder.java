package com.zephie.jd2.classwork.core.entity;

import java.util.Calendar;

public class MessageBuilder {
    private long id;
    private String text;
    private String sender;
    private String recipient;
    private Calendar date;

    private MessageBuilder() {
    }

    public static MessageBuilder create() {
        return new MessageBuilder();
    }

    public MessageBuilder setId(long id) {
        this.id = id;
        return this;
    }

    public MessageBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public MessageBuilder setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public MessageBuilder setRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public MessageBuilder setDate(Calendar date) {
        this.date = date;
        return this;
    }

    public Message build() {
        return new Message(id, text, sender, recipient, date);
    }
}

