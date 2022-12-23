package com.andreick.manager.controller.route.login;

import com.andreick.manager.controller.route.Route;

public enum LoginRoute implements Route {

    FORM {
        @Override
        public String getUrl() {
            return "/login-form";
        }
    },
    LOGIN {
        @Override
        public String getUrl() {
            return "/login";
        }
    },
    LOGOUT {
        @Override
        public String getUrl() {
            return "/logout";
        }
    };

}
