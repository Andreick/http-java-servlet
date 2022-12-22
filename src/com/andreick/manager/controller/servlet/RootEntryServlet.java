package com.andreick.manager.controller.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.ActionResult;
import com.andreick.manager.controller.action.ActionUtil;
import com.andreick.manager.controller.action.company.ListCompanies;
import com.andreick.manager.controller.route.login.LoginRoute;

@WebServlet("/")
public class RootEntryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final String JSTL_PACKAGE = "WEB-INF/view/";
    private final Map<String, Action> actionMap = ActionUtil.getActionMap();

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String route = request.getServletPath();
        System.out.println(route);

        HttpSession session = request.getSession();

        boolean isUserNotAuthenticated = session.getAttribute("authenticatedUser") == null;
        boolean isProtectedRoute = !(route.equals(LoginRoute.FORM.getPath())
                || route.equals(LoginRoute.LOGIN.getPath()));

        if (isUserNotAuthenticated && isProtectedRoute) {
            redirect(LoginRoute.FORM.getPath(), response);
            return;
        }

        Action action = getAction(route);
        handleAction(action, request, response);
    }

    private void handleAction(Action action, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ActionResult actionResult = action.run(request, response);

        switch (actionResult.getType()) {
        case FOWARD:
            foward(actionResult.getPath(), request, response);
            break;
        case REDIRECT:
            redirect(actionResult.getPath(), response);
            break;
        }
    }

    private void redirect(String path, HttpServletResponse response) throws IOException {
        response.sendRedirect(path.substring(1));
    }

    private void foward(String path, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher reqDisp = request.getRequestDispatcher(JSTL_PACKAGE + path);
        reqDisp.forward(request, response);
    }

    private Action getAction(String route) throws ServletException {
        Action action = actionMap.get(route);

        if (action == null) {
            return new ListCompanies();
        }

        return action;
    }

}
