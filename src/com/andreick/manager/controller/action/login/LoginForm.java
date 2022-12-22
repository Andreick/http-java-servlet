package com.andreick.manager.controller.action.login;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.ActionResult;
import com.andreick.manager.controller.action.ActionType;

public class LoginForm implements Action {

    @Override
    public ActionResult run(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        return new ActionResult(ActionType.FOWARD, "loginForm.jsp");
    }

}
