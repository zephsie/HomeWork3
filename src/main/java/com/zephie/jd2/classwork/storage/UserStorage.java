package com.zephie.jd2.classwork.storage;

import com.zephie.jd2.classwork.core.entity.User;
import com.zephie.jd2.classwork.core.entity.UserBuilder;
import com.zephie.jd2.classwork.storage.api.IUserStorage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UserStorage implements IUserStorage {
    private static volatile UserStorage instance = null;
    private final Set<User> data = new HashSet<>();
    private final Lock lock = new ReentrantLock();
    private long id = 0L;

    private UserStorage() {
        try {
            lock.lock();
            data.add(UserBuilder.create()
                    .setId(id++)
                    .setLogin("admin")
                    .setPassword("admin")
                    .setFirstName("Admin")
                    .setLastName("Admin")
                    .setBirthDate(LocalDate.of(1990, 1, 1))
                    .setRegistrationDate(LocalDateTime.now())
                    .setRole(User.Role.ADMIN)
                    .build());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Collection<User> get() {
        try {
            lock.lock();
            return data;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Optional<User> get(long id) {
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
    public void save(User item) {
        try {
            lock.lock();
            item.setId(id++);
            data.add(item);
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

    @Override
    public Optional<User> get(String login) {
        try {
            lock.lock();
            return data.stream()
                    .filter(item -> item.getLogin().equals(login))
                    .findFirst();
        } finally {
            lock.unlock();
        }
    }

    public static UserStorage getInstance() {
        if (instance == null) {
            synchronized (UserStorage.class) {
                if (instance == null) {
                    instance = new UserStorage();
                }
            }
        }
        return instance;
    }
}


