package com.zephie.jd2.classwork.controllers.web.servlets.api;

import com.zephie.jd2.classwork.core.dto.UserLoginDTO;
import com.zephie.jd2.classwork.services.AuthService;
import com.zephie.jd2.classwork.services.api.IAuthService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignInServlet", urlPatterns = "/api/login")
public class SignInServlet extends HttpServlet {
    private final IAuthService authService = AuthService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        req.getSession().setAttribute("user", authService.login(new UserLoginDTO(login, password)));
        resp.sendRedirect(req.getContextPath() + "/ui");
    }
}
