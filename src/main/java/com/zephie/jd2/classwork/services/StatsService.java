package com.zephie.jd2.classwork.services;

import com.zephie.jd2.classwork.services.api.IMessageService;
import com.zephie.jd2.classwork.services.api.IStatsService;
import com.zephie.jd2.classwork.services.api.IUserService;

import java.util.concurrent.atomic.AtomicInteger;

public class StatsService implements IStatsService {
    private final IUserService userService = UserService.getInstance();
    private final IMessageService messageService = MessageService.getInstance();
    private final AtomicInteger counter = new AtomicInteger(0);

    private static StatsService instance = null;

    private StatsService() {
    }

    public static StatsService getInstance() {
        if (instance == null) {
            instance = new StatsService();
        }
        return instance;
    }

    @Override
    public long getMessagesCount() {
        return messageService.get().size();
    }

    @Override
    public long getUsersCount() {
        return userService.get().size();
    }

    @Override
    public long getActiveUsersCount() {
        return counter.get();
    }

    public void incrementActiveUsersCount() {
        counter.incrementAndGet();
    }

    public void decrementActiveUsersCount() {
        counter.decrementAndGet();
    }
}
