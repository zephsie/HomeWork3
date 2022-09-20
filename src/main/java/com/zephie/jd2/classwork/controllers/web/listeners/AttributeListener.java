package com.zephie.jd2.classwork.controllers.web.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class AttributeListener
        implements HttpSessionAttributeListener {
    private static final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (httpSessionBindingEvent.getName().equals("user")) {
            counter.incrementAndGet();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        if (httpSessionBindingEvent.getName().equals("user")) {
            counter.decrementAndGet();
        }
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
    }

    public static int getCounter() {
        return counter.get();
    }
}