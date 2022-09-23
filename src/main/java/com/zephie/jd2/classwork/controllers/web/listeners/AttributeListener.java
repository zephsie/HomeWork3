package com.zephie.jd2.classwork.controllers.web.listeners;

import com.zephie.jd2.classwork.services.StatsService;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class AttributeListener
        implements HttpSessionAttributeListener {
    private final StatsService statsService = StatsService.getInstance();

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (httpSessionBindingEvent.getName().equals("user")) {
            statsService.incrementActiveUsersCount();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (httpSessionBindingEvent.getName().equals("user")) {
            statsService.decrementActiveUsersCount();
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
    }
}