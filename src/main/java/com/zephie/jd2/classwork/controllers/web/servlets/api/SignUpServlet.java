package com.zephie.jd2.classwork.controllers.web.servlets.api;

import com.zephie.jd2.classwork.core.dto.UserDTOBuilder;
import com.zephie.jd2.classwork.services.UserService;
import com.zephie.jd2.classwork.services.api.IUserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

        UserDTOBuilder userDTOBuilder = UserDTOBuilder.create();

        try {
            userDTOBuilder = userDTOBuilder.setBirthDate(LocalDate.parse(birthDate, DateTimeFormatter.ISO_LOCAL_DATE));
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format");
        }

        userDTOBuilder = userDTOBuilder.setLogin(login)
                .setPassword(password)
                .setFirstName(firstName)
                .setLastName(lastName);

        artistService.signUp(userDTOBuilder.build());

        req.setAttribute("signInLink", "/ui/signIn");
        req.setAttribute("signUpLink", "/ui/signUp");
        req.setAttribute("sendMessageLink", "/ui/user/message");
        req.setAttribute("inboxLink", "/ui/user/chats");

        resp.sendRedirect(req.getContextPath() + "/ui");
    }
}