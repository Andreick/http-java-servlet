package com.andreick.manager.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.model.Company;
import com.andreick.manager.model.FakeDatabase;

public class ListCompanies {

    public void run(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        FakeDatabase db = new FakeDatabase();
        List<Company> companies = db.getCompanies();

        RequestDispatcher reqDisp = request.getRequestDispatcher("/companiesList.jsp");
        request.setAttribute("companies", companies);
        reqDisp.forward(request, response);
    }

}
