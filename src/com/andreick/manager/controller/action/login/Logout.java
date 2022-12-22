package com.andreick.manager.controller.action.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.ActionResult;
import com.andreick.manager.controller.action.ActionType;
import com.andreick.manager.controller.route.login.LoginRoute;

public class Logout implements Action {

    @Override
    public ActionResult run(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        HttpSession session = request.getSession();
        session.invalidate();
        return new ActionResult(ActionType.REDIRECT, LoginRoute.FORM.getPath());
    }

}
