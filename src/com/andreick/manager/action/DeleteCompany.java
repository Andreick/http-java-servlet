package com.andreick.manager.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.model.FakeDatabase;

public class DeleteCompany {

    public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Deleting company");

        String paramId = request.getParameter("id");
        int id = Integer.parseInt(paramId);

        FakeDatabase db = new FakeDatabase();
        db.deleteCompanyById(id);

        response.sendRedirect("list-companies");
    }

}
