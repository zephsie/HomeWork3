package com.zephie.jd2.classwork.controllers;

import com.zephie.jd2.classwork.core.entity.User;
import com.zephie.jd2.classwork.services.UserService;
import com.zephie.jd2.classwork.services.api.IUserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "LoginServlet", urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {
    IUserService artistService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Optional<User> user = artistService.login(login, password);

        if (user.isPresent()) {
            req.getSession().setAttribute("user", user.get());
        } else {
            throw new IllegalArgumentException("User not found");
        }

        resp.sendRedirect(req.getContextPath() + "/ui/user/message");
    }
}
