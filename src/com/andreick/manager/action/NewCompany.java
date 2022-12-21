package com.andreick.manager.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.model.Company;
import com.andreick.manager.model.FakeDatabase;

public class NewCompany {

    public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Registering new company");

        String paramName = request.getParameter("name");
        String paramStartDate = request.getParameter("startDate");

        Date startDate;
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            startDate = formatter.parse(paramStartDate);
        } catch (ParseException e) {
            throw new ServletException(e);
        }

        Company newCompany = new Company(paramName, startDate);

        FakeDatabase db = new FakeDatabase();
        db.create(newCompany);

        request.setAttribute("newCompanyName", newCompany.getName());
        response.sendRedirect("list-companies");
    }

}
