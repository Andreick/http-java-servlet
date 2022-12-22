package com.andreick.manager.controller.action.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.ActionResult;
import com.andreick.manager.controller.action.ActionType;
import com.andreick.manager.controller.route.company.CompanyRoute;
import com.andreick.manager.controller.route.login.LoginRoute;
import com.andreick.manager.model.FakeDatabase;
import com.andreick.manager.model.User;

public class Login implements Action {

    @Override
    public ActionResult run(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String paramLogin = request.getParameter("login");
        String paramPassword = request.getParameter("password");

        FakeDatabase db = new FakeDatabase();
        User authenticatedUser = db.getAuthenticatedUser(paramLogin, paramPassword);

        if (authenticatedUser == null) {
            return new ActionResult(ActionType.REDIRECT, LoginRoute.FORM.getPath());
        }

        return new ActionResult(ActionType.REDIRECT, CompanyRoute.LIST.getPath());
    }

}
