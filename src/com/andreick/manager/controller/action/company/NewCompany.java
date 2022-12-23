package com.andreick.manager.controller.action.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.ActionResult;
import com.andreick.manager.controller.action.ActionType;
import com.andreick.manager.controller.route.company.CompanyRoute;
import com.andreick.manager.model.Company;
import com.andreick.manager.model.FakeDatabase;

public class NewCompany implements Action {

    @Override
    public ActionResult run(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("Registering new company");

        String paramName = request.getParameter("name");
        String paramStartDate = request.getParameter("startDate");

        Date startDate;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            startDate = formatter.parse(paramStartDate);
        } catch (ParseException e) {
            return new ActionResult(ActionType.ERROR, e.getMessage());
        }

        Company newCompany = new Company(paramName, startDate);

        FakeDatabase db = new FakeDatabase();
        db.create(newCompany);

        request.setAttribute("newCompanyName", newCompany.getName());
        return new ActionResult(ActionType.REDIRECT, CompanyRoute.LIST.getUrl());
    }

}
