package com.zephie.jd2.classwork.storage;

import com.zephie.jd2.classwork.core.entity.User;
import com.zephie.jd2.classwork.core.entity.UserBuilder;
import com.zephie.jd2.classwork.storage.api.IUserStorage;

import java.time.Year;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UserStorage implements IUserStorage {
    private static UserStorage instance = null;
    private final Set<User> data = new HashSet<>();
    private final Lock lock = new ReentrantLock();
    private long id = 0L;

    private UserStorage() {
        lock.lock();
        try {
            data.add(UserBuilder.create()
                    .setId(id++)
                    .setLogin("admin")
                    .setPassword("admin")
                    .setFirstName("Admin")
                    .setLastName("Admin")
                    .setBirthDate(new GregorianCalendar(2003, Calendar.JANUARY, 1))
                    .setRegistrationDate(GregorianCalendar.getInstance())
                    .setRole(User.Role.ADMIN)
                    .build());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Set<User> get() {
        lock.lock();
        try {
            return data;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Optional<User> get(long id) {
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
    public void save(User item) {
        lock.lock();
        try {
            item.setId(id++);
            item.setRegistrationDate(GregorianCalendar.getInstance());
            item.setRole(User.Role.USER);
            data.add(item);
        } finally {
            lock.unlock();
        }
    }

    public static UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }
}


