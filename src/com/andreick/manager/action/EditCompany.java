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

public class EditCompany {

    public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        response.sendRedirect("list-companies");
    }

}
