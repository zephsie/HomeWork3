package com.zephie.jd2.classwork.services.api;

import com.zephie.jd2.classwork.core.entity.Message;

import java.util.Set;

public interface IMessageService extends IEssenceService<Message> {
    Set<Message> get(String login);
    long getNumberOfEntries();
}
