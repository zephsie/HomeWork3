package com.zephie.jd2.classwork.storage.api;

import com.zephie.jd2.classwork.core.entity.User;

import java.util.Optional;

public interface IUserStorage extends IEssenceStorage<User> {
    Optional<User> get(String login);
}
