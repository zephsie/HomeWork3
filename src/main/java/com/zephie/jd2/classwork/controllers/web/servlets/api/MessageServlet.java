package com.zephie.jd2.classwork.controllers.web.servlets.api;

import com.zephie.jd2.classwork.core.entity.MessageBuilder;
import com.zephie.jd2.classwork.core.entity.User;
import com.zephie.jd2.classwork.services.MessageService;
import com.zephie.jd2.classwork.services.api.IMessageService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    private final IMessageService messageService = MessageService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        User user = (User) req.getSession(true).getAttribute("user");

        String login = req.getParameter("login");
        String message = req.getParameter("message");

        messageService.save(MessageBuilder.create()
                .setSender(user.getLogin())
                .setRecipient(login)
                .setText(message)
                .build());

        resp.sendRedirect(req.getContextPath() + "/ui");
    }
}
