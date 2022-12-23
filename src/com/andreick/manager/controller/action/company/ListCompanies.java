package com.andreick.manager.controller.action.company;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.ActionResult;
import com.andreick.manager.controller.action.ActionType;
import com.andreick.manager.model.Company;
import com.andreick.manager.model.FakeDatabase;

public class ListCompanies implements Action {

    @Override
    public ActionResult run(HttpServletRequest request, HttpServletResponse response) {

        FakeDatabase db = new FakeDatabase();
        List<Company> companies = db.getCompanies();

        request.setAttribute("companies", companies);
        return new ActionResult(ActionType.FOWARD, "companiesList.jsp");
    }

}
