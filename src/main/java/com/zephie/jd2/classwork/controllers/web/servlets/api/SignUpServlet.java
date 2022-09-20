package com.zephie.jd2.classwork.controllers.web.servlets.api;

import com.zephie.jd2.classwork.core.entity.UserBuilder;
import com.zephie.jd2.classwork.services.UserService;
import com.zephie.jd2.classwork.services.api.IUserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@WebServlet(name = "SignUpServlet", urlPatterns = "/api/user")
public class SignUpServlet extends HttpServlet {
    private final IUserService artistService = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String birthDate = req.getParameter("birthDate");

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(birthDate));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Birth date is invalid");
        }

        artistService.save(UserBuilder.create()
                .setLogin(login)
                .setPassword(password)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setBirthDate(calendar)
                .build());

        req.setAttribute("signInLink", "/ui/signIn");
        req.setAttribute("signUpLink", "/ui/signUp");
        req.setAttribute("sendMessageLink", "/ui/user/message");
        req.setAttribute("inboxLink", "/ui/user/chats");

        resp.sendRedirect(req.getContextPath() + "/ui");
    }
}
