package com.andreick.manager.controller.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.ActionResult;
import com.andreick.manager.controller.action.ActionType;
import com.andreick.manager.controller.route.company.CompanyRoute;
import com.andreick.manager.controller.route.login.LoginRoute;
import com.andreick.manager.model.FakeDatabase;
import com.andreick.manager.model.User;

public class Login implements Action {

    @Override
    public ActionResult run(HttpServletRequest request, HttpServletResponse response) {

        String paramLogin = request.getParameter("login");
        String paramPassword = request.getParameter("password");

        FakeDatabase db = new FakeDatabase();
        User authenticatedUser = db.getAuthenticatedUser(paramLogin, paramPassword);

        if (authenticatedUser == null) {
            return new ActionResult(ActionType.REDIRECT, LoginRoute.FORM.getUrl());
        }

        HttpSession session = request.getSession();
        session.setAttribute("authenticatedUser", authenticatedUser);
        return new ActionResult(ActionType.REDIRECT, CompanyRoute.LIST.getUrl());
    }

}
