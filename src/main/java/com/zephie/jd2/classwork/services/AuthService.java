package com.zephie.jd2.classwork.services;

import com.zephie.jd2.classwork.core.dto.UserLoginDTO;
import com.zephie.jd2.classwork.core.entity.User;
import com.zephie.jd2.classwork.services.api.IAuthService;
import com.zephie.jd2.classwork.services.api.IUserService;

import java.util.Optional;

public class AuthService implements IAuthService {

    private static AuthService instance;
    private final IUserService userService;

    private AuthService() {
        userService = UserService.getInstance();
    }

    @Override
    public User login(UserLoginDTO userLoginDTO) {
        Optional<User> user = userService.get(userLoginDTO.getLogin());

        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        if (!user.get().getPassword().equals(userLoginDTO.getPassword())) {
            throw new IllegalArgumentException("Wrong password");
        }

        return user.get();
    }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }
}
