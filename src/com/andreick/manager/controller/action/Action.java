package com.andreick.manager.controller.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

    ActionResult run(HttpServletRequest request, HttpServletResponse response) throws ServletException;

}
