package com.zephie.jd2.classwork.controllers.web.servlets.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignInFormServlet", urlPatterns = "/ui/signIn")
public class SignInFormServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        req.setAttribute("signUpLink", "/ui/signUp");
        req.setAttribute("mainPageLink", "/ui");

        req.getRequestDispatcher("/signInForm.jsp").forward(req, resp);
    }
}
