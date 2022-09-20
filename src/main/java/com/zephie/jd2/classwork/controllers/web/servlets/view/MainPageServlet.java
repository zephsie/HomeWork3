package com.zephie.jd2.classwork.controllers.web.servlets.view;

import com.zephie.jd2.classwork.services.UserService;
import com.zephie.jd2.classwork.services.api.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainPageServlet", urlPatterns = "/ui")
public class MainPageServlet extends HttpServlet {
    private final IUserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        req.setAttribute("users", userService.get());
        req.setAttribute("signInLink", "/ui/signIn");
        req.setAttribute("signUpLink", "/ui/signUp");
        req.setAttribute("sendMessageLink", "/ui/user/message");
        req.setAttribute("inboxLink", "/ui/user/chats");
        req.setAttribute("statisticsLink", "/ui/admin/statistics");

        req.getRequestDispatcher("/mainPage.jsp").forward(req, resp);
    }
}
