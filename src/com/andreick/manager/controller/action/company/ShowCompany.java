package com.andreick.manager.controller.action.company;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.ActionResult;
import com.andreick.manager.controller.action.ActionType;
import com.andreick.manager.model.Company;
import com.andreick.manager.model.FakeDatabase;

public class ShowCompany implements Action {

    @Override
    public ActionResult run(HttpServletRequest request, HttpServletResponse response) {

        String paramId = request.getParameter("id");
        int id = Integer.parseInt(paramId);

        FakeDatabase db = new FakeDatabase();
        Company company = db.getCompanyById(id);

        request.setAttribute("company", company);
        return new ActionResult(ActionType.FOWARD, "editCompanyForm.jsp");
    }

}
