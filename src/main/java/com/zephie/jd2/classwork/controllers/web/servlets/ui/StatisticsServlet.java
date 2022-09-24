package com.zephie.jd2.classwork.controllers.web.servlets.ui;

import com.zephie.jd2.classwork.services.StatsService;
import com.zephie.jd2.classwork.services.api.IStatsService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "StatisticsServlet", urlPatterns = "/ui/admin/statistics")
public class StatisticsServlet extends HttpServlet {
    private final IStatsService statsService = StatsService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        req.setAttribute("numberOfUsers", statsService.userCount());
        req.setAttribute("numberOfMessages", statsService.messageCount());
        req.setAttribute("numberOfActiveUsers", statsService.getSessionCount());

        req.getRequestDispatcher("/stats.jsp").forward(req, resp);
    }
}
