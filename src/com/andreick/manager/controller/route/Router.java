package com.andreick.manager.controller.route;

import java.util.Map;

import com.andreick.manager.controller.action.Action;

public interface Router {

    void putActions(Map<String, Action> actionMap);

}
