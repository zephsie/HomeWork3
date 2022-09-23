package com.zephie.jd2.classwork.controllers.web.filters;

import com.zephie.jd2.classwork.core.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/ui/admin/*", "/api/admin/*"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        User user = (User) req.getSession(true).getAttribute("user");

        if (user != null) {
            if (user.getRole() == User.Role.ADMIN) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                throw new IllegalArgumentException("User is not admin");
            }
        } else {
            res.sendRedirect(req.getContextPath() + "/ui/signIn");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }
}
