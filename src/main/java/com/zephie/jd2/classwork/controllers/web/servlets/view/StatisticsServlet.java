package com.zephie.jd2.classwork.controllers.web.servlets.view;

import com.zephie.jd2.classwork.controllers.web.listeners.AttributeListener;
import com.zephie.jd2.classwork.services.MessageService;
import com.zephie.jd2.classwork.services.UserService;
import com.zephie.jd2.classwork.services.api.IMessageService;
import com.zephie.jd2.classwork.services.api.IUserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatisticsServlet", urlPatterns = "/ui/admin/statistics")
public class StatisticsServlet extends HttpServlet {

    private final IUserService userService = UserService.getInstance();
    private final IMessageService messageService = MessageService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Statistics</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>Statistics</h1>");
        writer.println("<h2>" + userService.numberOfUsers() + " users</h2>");
        writer.println("<h2>" + messageService.numberOfMessages() + " messages</h2>");
        writer.println("<h2>" + AttributeListener.getCounter() + " active users</h2>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
