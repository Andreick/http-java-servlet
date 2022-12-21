package com.andreick.manager.controller.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.ActionResult;
import com.andreick.manager.controller.action.ActionUtil;

@WebServlet("/")
public class RootEntryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final String JSTL_PACKAGE = "WEB-INF/view/";
    private final Map<String, Action> actionMap = ActionUtil.getActionMap();

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String route = request.getServletPath();
        Action action = getAction(route);
        handleAction(action, request, response);
    }

    private void handleAction(Action action, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ActionResult actionResult = action.run(request, response);

        switch (actionResult.getType()) {
        case FOWARD:
            RequestDispatcher reqDisp = request.getRequestDispatcher(JSTL_PACKAGE + actionResult.getPath());
            reqDisp.forward(request, response);
            break;
        case REDIRECT:
            response.sendRedirect(actionResult.getPath().substring(1));
            break;
        }
    }

    private Action getAction(String route) throws ServletException {

        Action action = actionMap.get(route);

        if (action == null) {
            throw new ServletException("Unknown route");
        }

        return action;
    }

}
