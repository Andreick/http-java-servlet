package com.andreick.manager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.data.Company;
import com.andreick.manager.repo.FakeDatabase;

@WebServlet("/companies")
public class ListCompaniesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FakeDatabase db = new FakeDatabase();
        List<Company> companies = db.getCompanies();

        RequestDispatcher reqDisp = request.getRequestDispatcher("/companies.jsp");
        request.setAttribute("companies", companies);
        reqDisp.forward(request, response);
    }

}
