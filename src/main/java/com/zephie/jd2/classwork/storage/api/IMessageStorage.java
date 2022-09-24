package com.zephie.jd2.classwork.storage.api;

import com.zephie.jd2.classwork.core.entity.Message;

import java.util.Collection;

public interface IMessageStorage extends IEssenceStorage<Message> {
    Collection<Message> get(String login);
}