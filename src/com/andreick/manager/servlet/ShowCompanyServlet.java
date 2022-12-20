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
public class ShowCompanyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String paramId = request.getParameter("id");
        int id = Integer.parseInt(paramId);

        FakeDatabase db = new FakeDatabase();
        Company company = db.getCompanyById(id);

        RequestDispatcher reqDisp = request.getRequestDispatcher("/editCompanyForm.jsp");
        request.setAttribute("company", company);
        reqDisp.forward(request, response);
    }

}
