package com.andreick.manager.controller.route.login;

import com.andreick.manager.controller.route.Route;

public enum LoginRoute implements Route {

    FORM {
        @Override
        public String getPath() {
            return "/login-form";
        }
    },
    LOGIN {
        @Override
        public String getPath() {
            return "/login";
        }
    },
    LOGOUT {
        @Override
        public String getPath() {
            return "/logout";
        }
    };

}
