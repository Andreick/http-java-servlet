package com.andreick.manager.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.data.Company;
import com.andreick.manager.repo.FakeDatabase;

@WebServlet("/company")
public class NewCompanyServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Registering new company");

        String newCompanyName = request.getParameter("name");
        Company newCompany = new Company(newCompanyName);

        FakeDatabase db = new FakeDatabase();
        db.add(newCompany);

        RequestDispatcher reqDisp = request.getRequestDispatcher("/newCompany.jsp");
        request.setAttribute("companyName", newCompanyName);
        reqDisp.forward(request, response);
    }

}
