package com.zephie.jd2.classwork.controllers.web.servlets.ui;

import com.zephie.jd2.classwork.core.entity.User;
import com.zephie.jd2.classwork.services.MessageService;
import com.zephie.jd2.classwork.services.api.IMessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InboxServlet", urlPatterns = "/ui/user/chats")
public class InboxServlet extends HttpServlet {
    private final IMessageService messageService = MessageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            throw new SecurityException("User is not authorized");
        }

        req.setAttribute("messageSet", messageService.get(user.getLogin()));

        req.setAttribute("sendMessageLink", "/ui/user/message");
        req.setAttribute("mainPageLink", "/ui");

        req.getRequestDispatcher("/inbox.jsp").forward(req, resp);
    }
}
