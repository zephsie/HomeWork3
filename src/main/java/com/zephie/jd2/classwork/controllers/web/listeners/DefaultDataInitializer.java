package com.zephie.jd2.classwork.controllers.web.listeners;

import com.zephie.jd2.classwork.core.dto.UserDTOBuilder;
import com.zephie.jd2.classwork.services.UserService;
import com.zephie.jd2.classwork.services.api.IUserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;

@WebListener
public class DefaultDataInitializer implements ServletContextListener {
    IUserService userService = UserService.getInstance();

    @Override
    public void contextInitialized(javax.servlet.ServletContextEvent sce) {
            userService.signUp(UserDTOBuilder.create()
                    .setLogin("user")
                    .setPassword("user")
                    .setFirstName("User")
                    .setLastName("User")
                    .setBirthDate(LocalDate.of(2003, 1, 1))
                    .build());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
