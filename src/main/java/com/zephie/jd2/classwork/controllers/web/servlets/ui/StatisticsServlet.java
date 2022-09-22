package com.zephie.jd2.classwork.controllers.web.servlets.ui;

import com.zephie.jd2.classwork.controllers.web.listeners.AttributeListener;
import com.zephie.jd2.classwork.services.MessageService;
import com.zephie.jd2.classwork.services.UserService;
import com.zephie.jd2.classwork.services.api.IMessageService;
import com.zephie.jd2.classwork.services.api.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StatisticsServlet", urlPatterns = "/ui/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    private final IUserService userService = UserService.getInstance();
    private final IMessageService messageService = MessageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        req.setAttribute("numberOfUsers", userService.numberOfUsers());
        req.setAttribute("numberOfMessages", messageService.numberOfMessages());
        req.setAttribute("numberOfActiveUsers", AttributeListener.getCounter());

        req.getRequestDispatcher("/stats.jsp").forward(req, resp);
    }
}
