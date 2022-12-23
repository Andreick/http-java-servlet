package com.andreick.manager.controller.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andreick.manager.controller.route.login.LoginRoute;

public class AuthFilter extends HttpFilter {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        System.out.println("AuthFilter");

        HttpSession session = req.getSession();

        boolean isUserNotAuthenticated = session.getAttribute("authenticatedUser") == null;

        if (isUserNotAuthenticated) {
            String route = req.getServletPath();

            boolean isProtectedRoute = !(route.equals(LoginRoute.FORM.getUrl())
                    || route.equals(LoginRoute.LOGIN.getUrl()));

            if (isProtectedRoute) {
                res.sendRedirect(req.getContextPath() + LoginRoute.FORM.getUrl());
                return;
            }
        }

        super.doFilter(req, res, chain);
    }

}
