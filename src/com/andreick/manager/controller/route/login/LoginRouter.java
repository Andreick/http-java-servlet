package com.andreick.manager.controller.route.login;

import java.util.Map;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.login.Login;
import com.andreick.manager.controller.action.login.LoginForm;
import com.andreick.manager.controller.action.login.Logout;
import com.andreick.manager.controller.route.Router;

public class LoginRouter implements Router {

    @Override
    public void putActions(Map<String, Action> actionMap) {
        actionMap.put(LoginRoute.FORM.getPath(), new LoginForm());
        actionMap.put(LoginRoute.LOGIN.getPath(), new Login());
        actionMap.put(LoginRoute.LOGOUT.getPath(), new Logout());
    }

}
