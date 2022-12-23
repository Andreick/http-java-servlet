package com.andreick.manager.controller.action.company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.ActionResult;
import com.andreick.manager.controller.action.ActionType;

public class NewCompanyForm implements Action {

    @Override
    public ActionResult run(HttpServletRequest request, HttpServletResponse response) {

        return new ActionResult(ActionType.FOWARD, "newCompanyForm.jsp");
    }

}
