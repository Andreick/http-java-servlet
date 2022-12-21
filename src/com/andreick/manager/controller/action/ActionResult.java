package com.andreick.manager.controller.action;

public class ActionResult {

    private ActionType type;
    private String path;

    public ActionResult(ActionType type, String path) {
        this.type = type;
        this.path = path;
    }

    public ActionType getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

}
