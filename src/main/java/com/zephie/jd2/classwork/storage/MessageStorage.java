package com.zephie.jd2.classwork.storage;

import com.zephie.jd2.classwork.core.entity.Message;
import com.zephie.jd2.classwork.storage.api.IMessageStorage;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageStorage implements IMessageStorage {
    private static MessageStorage instance = null;
    private final Set<Message> data = new HashSet<>();
    private final Lock lock = new ReentrantLock();
    private long id = 0L;

    private MessageStorage() {
    }

    @Override
    public Set<Message> get() {
        lock.lock();
        try {
            return data;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Optional<Message> get(long id) {
        lock.lock();
        try {
            return data.stream()
                    .filter(item -> item.getId() == id)
                    .findFirst();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void save(Message item) {
        lock.lock();
        try {
            item.setId(id++);
            item.setDate(GregorianCalendar.getInstance());
            data.add(item);
        } finally {
            lock.unlock();
        }
    }

    public static MessageStorage getInstance() {
        if (instance == null) {
            instance = new MessageStorage();
        }
        return instance;
    }
}
