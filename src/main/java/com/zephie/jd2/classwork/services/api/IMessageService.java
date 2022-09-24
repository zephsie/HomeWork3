package com.zephie.jd2.classwork.services.api;

import com.zephie.jd2.classwork.core.dto.MessageDTO;
import com.zephie.jd2.classwork.core.entity.Message;

import java.util.Collection;

public interface IMessageService extends IEssenceService<Message> {
    Collection<Message> get(String login);

    void send(MessageDTO messageDTO);
    long getCount();
}
