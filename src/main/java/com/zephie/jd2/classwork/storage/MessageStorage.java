package com.zephie.jd2.classwork.storage;

import com.zephie.jd2.classwork.core.entity.Message;
import com.zephie.jd2.classwork.storage.api.IMessageStorage;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class MessageStorage implements IMessageStorage {
    private static MessageStorage instance = null;
    private final Set<Message> data = new HashSet<>();
    private final Lock lock = new ReentrantLock();
    private long id = 0L;

    private MessageStorage() {
    }

    @Override
    public Set<Message> get() {
        try {
            lock.lock();
            return data;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Optional<Message> get(long id) {
        try {
            lock.lock();
            return data.stream()
                    .filter(item -> item.getId() == id)
                    .findFirst();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void save(Message item) {
        try {
            lock.lock();
            item.setId(id++);
            data.add(item);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Collection<Message> get(String login) {
        try {
            lock.lock();
            return data.stream()
                    .filter(item -> item.getRecipient().equals(login))
                    .collect(Collectors.toList());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public long getCount() {
        try {
            lock.lock();
            return data.size();
        } finally {
            lock.unlock();
        }
    }

    public static MessageStorage getInstance() {
        if (instance == null) {
            synchronized (MessageStorage.class) {
                if (instance == null) {
                    instance = new MessageStorage();
                }
            }
        }
        return instance;
    }
}
