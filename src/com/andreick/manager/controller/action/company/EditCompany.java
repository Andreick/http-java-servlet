package com.andreick.manager.controller.action.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.ActionResult;
import com.andreick.manager.controller.action.ActionType;
import com.andreick.manager.controller.route.company.CompanyRoute;
import com.andreick.manager.model.Company;
import com.andreick.manager.model.FakeDatabase;

public class EditCompany implements Action {

    @Override
    public ActionResult run(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        System.out.println("Editing company");

        String paramId = request.getParameter("id");
        String paramName = request.getParameter("name");
        String paramStartDate = request.getParameter("startDate");
        Long id = Long.valueOf(paramId);

        Date startDate;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            startDate = formatter.parse(paramStartDate);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        FakeDatabase db = new FakeDatabase();
        Company company = new Company(id, paramName, startDate);
        db.update(company);

        return new ActionResult(ActionType.REDIRECT, CompanyRoute.LIST.getPath());
    }

}
