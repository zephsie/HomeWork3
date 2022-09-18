package com.zephie.jd2.classwork.services;

import com.zephie.jd2.classwork.core.entity.Message;
import com.zephie.jd2.classwork.services.api.IMessageService;
import com.zephie.jd2.classwork.services.api.IUserService;
import com.zephie.jd2.classwork.storage.MessageStorage;
import com.zephie.jd2.classwork.storage.api.IMessageStorage;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MessageService implements IMessageService {
    private static final IMessageStorage storage = MessageStorage.getInstance();
    private static final IUserService userService = UserService.getInstance();

    private static MessageService instance = null;

    private MessageService() {
    }

    @Override
    public Set<Message> get() {
        return storage.get();
    }

    @Override
    public Optional<Message> get(long id) {
        return storage.get(id);
    }

    @Override
    public void validate(Message item) {
        if (item == null) {
            throw new IllegalStateException("No letter passed");
        }

        if (item.getSender() == null || item.getSender().isBlank()) {
            throw new IllegalStateException("Sender is empty");
        }

        if (item.getRecipient() == null || item.getRecipient().isBlank()) {
            throw new IllegalStateException("Receiver is empty");
        }

        if (userService.get().stream().noneMatch(user -> user.getLogin().equals(item.getSender()))) {
            throw new IllegalStateException("Sender does not exist");
        }

        if (userService.get().stream().noneMatch(user -> user.getLogin().equals(item.getRecipient()))) {
            throw new IllegalStateException("Receiver does not exist");
        }

        if (item.getText() == null || item.getText().isBlank()) {
            throw new IllegalStateException("Text is empty");
        }
    }

    @Override
    public void save(Message item) {
        validate(item);
        storage.save(item);
    }

    @Override
    public Set<Message> get(String login) {
        return storage.get().stream()
                .filter(message -> message.getSender().equals(login) || message.getRecipient().equals(login))
                .collect(Collectors.toSet());
    }

    @Override
    public long numberOfMessages() {
        return storage.get().size();
    }

    public static MessageService getInstance() {
        if (instance == null) {
            instance = new MessageService();
        }
        return instance;
    }
}
