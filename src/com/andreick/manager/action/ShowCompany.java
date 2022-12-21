package com.andreick.manager.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.model.Company;
import com.andreick.manager.model.FakeDatabase;

public class ShowCompany {

    public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramId = request.getParameter("id");
        int id = Integer.parseInt(paramId);

        FakeDatabase db = new FakeDatabase();
        Company company = db.getCompanyById(id);

        RequestDispatcher reqDisp = request.getRequestDispatcher("/editCompanyForm.jsp");
        request.setAttribute("company", company);
        reqDisp.forward(request, response);
    }

}
