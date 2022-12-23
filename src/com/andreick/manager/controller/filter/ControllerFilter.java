package com.andreick.manager.controller.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.ActionResult;
import com.andreick.manager.controller.action.ActionUtil;

public class ControllerFilter extends HttpFilter {

    private static final long serialVersionUID = 1L;

    private final String JSTL_PACKAGE = "WEB-INF/view/";
    private final Map<String, Action> actionMap = ActionUtil.getActionMap();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        String route = req.getServletPath();
        System.out.println(route);
        Action action = actionMap.get(route);
        handleAction(action, req, res);
    }

    private void handleAction(Action action, HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        if (action == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND, "Unknown url");
            return;
        }

        ActionResult actResult = action.run(req, res);
        String result = actResult.getResult();

        switch (actResult.getType()) {
        case FOWARD:
            RequestDispatcher reqDisp = req.getRequestDispatcher(JSTL_PACKAGE + result);
            reqDisp.forward(req, res);
            break;
        case REDIRECT:
            res.sendRedirect(req.getContextPath() + result);
            break;
        case ERROR:
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, result);
            break;
        }
    }

}
