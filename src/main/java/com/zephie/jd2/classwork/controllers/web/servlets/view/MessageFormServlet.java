package com.zephie.jd2.classwork.controllers.web.servlets.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MessageFormServlet", urlPatterns = "/ui/user/message")
public class MessageFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        req.setAttribute("mainPageLink", "/ui");
        req.setAttribute("inboxLink", "/ui/user/chats");

        req.getRequestDispatcher("/messageForm.jsp").forward(req, resp);
    }
}
