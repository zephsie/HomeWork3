package com.zephie.jd2.classwork.controllers.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionCounter implements HttpSessionListener {
    private static int sessionCount = 0;

    @Override
    public synchronized void sessionCreated(HttpSessionEvent sessionEvent) {
            sessionCount++;
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent sessionEvent) {
            sessionCount--;
    }

    public synchronized static int getSessionCount() {
        return sessionCount;
    }
}