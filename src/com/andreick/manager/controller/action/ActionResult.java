package com.andreick.manager.controller.action;

public class ActionResult {

    private ActionType type;
    private String result;

    public ActionResult(ActionType type, String result) {
        this.type = type;
        this.result = result;
    }

    public ActionType getType() {
        return type;
    }

    public String getResult() {
        return result;
    }

}
