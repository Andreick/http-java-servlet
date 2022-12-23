package com.andreick.manager.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

    ActionResult run(HttpServletRequest request, HttpServletResponse response);

}
