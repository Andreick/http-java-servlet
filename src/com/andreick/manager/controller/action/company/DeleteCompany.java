package com.andreick.manager.controller.action.company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.ActionResult;
import com.andreick.manager.controller.action.ActionType;
import com.andreick.manager.controller.route.company.CompanyRoute;
import com.andreick.manager.model.FakeDatabase;

public class DeleteCompany implements Action {

    @Override
    public ActionResult run(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("Deleting company");

        String paramId = request.getParameter("id");
        int id = Integer.parseInt(paramId);

        FakeDatabase db = new FakeDatabase();
        db.deleteCompanyById(id);

        return new ActionResult(ActionType.REDIRECT, CompanyRoute.LIST.getUrl());
    }

}
