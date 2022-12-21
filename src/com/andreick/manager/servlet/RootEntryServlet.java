package com.andreick.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.action.DeleteCompany;
import com.andreick.manager.action.EditCompany;
import com.andreick.manager.action.ListCompanies;
import com.andreick.manager.action.NewCompany;
import com.andreick.manager.action.ShowCompany;

@WebServlet("/")
public class RootEntryServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String route = request.getServletPath();

        switch (route) {
        case "/list-companies": {
            ListCompanies action = new ListCompanies();
            action.run(request, response);
            break;
        }
        case "/show-company": {
            ShowCompany action = new ShowCompany();
            action.run(request, response);
            break;
        }
        case "/new-company": {
            NewCompany action = new NewCompany();
            action.run(request, response);
            break;
        }
        case "/edit-company": {
            EditCompany action = new EditCompany();
            action.run(request, response);
            break;
        }
        case "/delete-company": {
            DeleteCompany action = new DeleteCompany();
            action.run(request, response);
            break;
        }
        }
    }

}
