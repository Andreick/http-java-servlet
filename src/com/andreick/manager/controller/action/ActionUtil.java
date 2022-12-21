package com.andreick.manager.controller.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.andreick.manager.controller.route.Router;
import com.andreick.manager.controller.route.RouterUtil;

public class ActionUtil {

    public static Map<String, Action> getActionMap() {

        List<Router> routers = RouterUtil.getRouters();
        Map<String, Action> actionMap = new HashMap<>();
        routers.forEach(router -> router.putActions(actionMap));
        return actionMap;
    }

}
