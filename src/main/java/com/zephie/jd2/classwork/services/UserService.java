package com.zephie.jd2.classwork.services;

import com.zephie.jd2.classwork.core.dto.UserDTO;
import com.zephie.jd2.classwork.core.entity.User;
import com.zephie.jd2.classwork.core.entity.UserBuilder;
import com.zephie.jd2.classwork.services.api.IUserService;
import com.zephie.jd2.classwork.storage.UserStorage;
import com.zephie.jd2.classwork.storage.api.IUserStorage;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Collection;
import java.util.Optional;

public class UserService implements IUserService {
    private final IUserStorage storage;

    private static UserService instance = null;

    private UserService() {
        storage = UserStorage.getInstance();
    }

    @Override
    public Collection<User> get() {
        return storage.get();
    }

    @Override
    public Optional<User> get(long id) {
        return storage.get(id);
    }

    public void validate(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalStateException("User is null");
        }

        StringBuilder errors = new StringBuilder();

        if (userDTO.getLogin() == null || userDTO.getLogin().isBlank()) {
            errors.append("Login is empty\n");
        }

        if (get(userDTO.getLogin()).isPresent()) {
            errors.append("User exists\n");
        }

        if (userDTO.getPassword() == null || userDTO.getPassword().isBlank()) {
            errors.append("Password is empty\n");
        }

        if (userDTO.getFirstName() == null || userDTO.getFirstName().isBlank()) {
            errors.append("First name is empty\n");
        }

        if (userDTO.getLastName() == null || userDTO.getLastName().isBlank()) {
            errors.append("Last name is empty\n");
        }

        if (userDTO.getBirthDate() == null) {
            errors.append("Birth date is empty\n");
        }

        if (userDTO.getBirthDate().isAfter(ChronoLocalDate.from(LocalDateTime.now()))) {
            errors.append("Birth date is in future\n");
        }

        if (userDTO.getBirthDate().isBefore(ChronoLocalDate.from(LocalDateTime.now().minusYears(150)))) {
            errors.append("Birth date is too old\n");
        }

        if (errors.length() != 0) {
            throw new IllegalArgumentException(errors.toString());
        }
    }

    @Override
    public long getCount() {
        return storage.getCount();
    }

    @Override
    public Optional<User> get(String login) {
        return storage.get(login);
    }

    @Override
    public void signUp(UserDTO userDTO) {
        validate(userDTO);

        storage.save(UserBuilder.create()
                .setLogin(userDTO.getLogin())
                .setPassword(userDTO.getPassword())
                .setFirstName(userDTO.getFirstName())
                .setLastName(userDTO.getLastName())
                .setBirthDate(userDTO.getBirthDate())
                .setRegistrationDate(LocalDateTime.now())
                .setRole(User.Role.USER)
                .build());
    }

    public static UserService getInstance() {
        if (instance == null) {
            synchronized (UserService.class) {
                if (instance == null) {
                    instance = new UserService();
                }
            }
        }
        return instance;
    }
}
