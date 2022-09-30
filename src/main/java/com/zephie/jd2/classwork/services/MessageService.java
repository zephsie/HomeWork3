package com.zephie.jd2.classwork.services;

import com.zephie.jd2.classwork.core.dto.MessageDTO;
import com.zephie.jd2.classwork.core.entity.Message;
import com.zephie.jd2.classwork.core.entity.MessageBuilder;
import com.zephie.jd2.classwork.services.api.IMessageService;
import com.zephie.jd2.classwork.services.api.IUserService;
import com.zephie.jd2.classwork.storage.MessageStorage;
import com.zephie.jd2.classwork.storage.api.IMessageStorage;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

public class MessageService implements IMessageService {
    private final IMessageStorage storage;
    private final IUserService userService;

    private static volatile MessageService instance = null;

    private MessageService() {
        storage = MessageStorage.getInstance();
        userService = UserService.getInstance();
    }

    @Override
    public Collection<Message> get() {
        return storage.get();
    }

    @Override
    public Optional<Message> get(long id) {
        return storage.get(id);
    }

    public void validate(MessageDTO messageDTO) {
        if (messageDTO == null) {
            throw new IllegalStateException("Message is null");
        }

        StringBuilder errors = new StringBuilder();

        if (messageDTO.getSender() == null || messageDTO.getSender().isBlank()) {
            errors.append("Sender is empty\n");
        }

        if (messageDTO.getRecipient() == null || messageDTO.getRecipient().isBlank() || userService.get(messageDTO.getRecipient()).isEmpty()) {
            errors.append("No recipient found\n");
        }

        if (messageDTO.getText() == null || messageDTO.getText().isBlank()) {
            errors.append("Text is empty\n");
        }

        if (errors.length() > 0) {
            throw new IllegalArgumentException(errors.toString());
        }
    }

    @Override
    public Collection<Message> get(String login) {
        return storage.get(login);
    }

    @Override
    public void send(MessageDTO messageDTO) {
        validate(messageDTO);

        storage.save(MessageBuilder.create()
                .setSender(messageDTO.getSender())
                .setRecipient(messageDTO.getRecipient())
                .setText(messageDTO.getText())
                .setDate(LocalDateTime.now())
                .build());
    }

    @Override
    public long getCount() {
        return storage.getCount();
    }

    public static MessageService getInstance() {
        if (instance == null) {
            synchronized (MessageService.class) {
                if (instance == null) {
                    instance = new MessageService();
                }
            }
        }
        return instance;
    }
}
