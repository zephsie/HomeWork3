package com.zephie.jd2.classwork.services.api;

import com.zephie.jd2.classwork.core.entity.Message;
import com.zephie.jd2.classwork.core.entity.User;

import java.util.Optional;
import java.util.Set;

public interface IUserService extends IEssenceService<User> {
    Optional<User> login(String login, String password);
    long numberOfUsers();
}