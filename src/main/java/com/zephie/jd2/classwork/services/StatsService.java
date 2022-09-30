package com.zephie.jd2.classwork.services;

import com.zephie.jd2.classwork.services.api.IMessageService;
import com.zephie.jd2.classwork.services.api.IStatsService;
import com.zephie.jd2.classwork.services.api.IUserService;

import java.util.concurrent.atomic.AtomicLong;

public class StatsService implements IStatsService {
    private final IUserService userService;
    private final IMessageService messageService;
    private final AtomicLong counter = new AtomicLong(0);

    private static volatile StatsService instance = null;

    private StatsService() {
        userService = UserService.getInstance();
        messageService = MessageService.getInstance();
    }

    public void incrementActiveUsersCount() {
        counter.incrementAndGet();
    }

    public void decrementActiveUsersCount() {
        counter.decrementAndGet();
    }

    @Override
    public long getSessionCount() {
        return counter.get();
    }

    @Override
    public long messageCount() {
        return messageService.getCount();
    }

    @Override
    public long userCount() {
        return userService.getCount();
    }


    public static StatsService getInstance() {
        if (instance == null) {
            synchronized (StatsService.class) {
                if (instance == null) {
                    instance = new StatsService();
                }
            }
        }
        return instance;
    }
}
