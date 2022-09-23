package com.zephie.jd2.classwork.services;

import com.zephie.jd2.classwork.core.entity.User;
import com.zephie.jd2.classwork.services.api.IUserService;
import com.zephie.jd2.classwork.storage.UserStorage;
import com.zephie.jd2.classwork.storage.api.IUserStorage;

import java.time.Year;
import java.util.Calendar;
import java.util.Optional;
import java.util.Set;

public class UserService implements IUserService {
    private final IUserStorage storage = UserStorage.getInstance();

    private static UserService instance = null;

    private UserService() {
    }

    @Override
    public Set<User> get() {
        return storage.get();
    }

    @Override
    public Optional<User> get(long id) {
        return storage.get(id);
    }

    @Override
    public void validate(User item) {
        if (item == null) {
            throw new IllegalStateException("No letter passed");
        }

        if (storage.get().contains(item)) {
            throw new IllegalStateException("User already exists");
        }

        if (item.getLogin() == null || item.getLogin().isBlank()) {
            throw new IllegalStateException("Login is empty");
        }

        if (item.getPassword() == null || item.getPassword().isBlank()) {
            throw new IllegalStateException("Password is empty");
        }

        if (item.getFirstName() == null || item.getFirstName().isBlank()) {
            throw new IllegalStateException("First name is empty");
        }

        if (item.getLastName() == null || item.getLastName().isBlank()) {
            throw new IllegalStateException("Last name is empty");
        }

        if (item.getBirthDate() == null) {
            throw new IllegalStateException("Birth date is empty");
        }

        if (item.getBirthDate().get(Calendar.YEAR) > Year.now().getValue()) {
            throw new IllegalStateException("Birth date is in the future");
        }

        if (item.getBirthDate().get(Calendar.YEAR) < 1900) {
            throw new IllegalStateException("Birth date is too old");
        }
    }

    @Override
    public void save(User item) {
        validate(item);
        storage.save(item);
    }

    @Override
    public Optional<User> login(String login, String password) {
        return storage.get().stream()
                .filter(item -> item.getLogin().equals(login) && item.getPassword().equals(password))
                .findFirst();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
}
