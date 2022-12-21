package com.andreick.manager.controller.route.company;

import com.andreick.manager.controller.route.Route;

public enum CompanyRoute implements Route {

    LIST {
        @Override
        public String getPath() {
            return "/list-companies";
        }
    },
    SHOW {
        @Override
        public String getPath() {
            return "/show-company";
        }
    },
    NEW {
        @Override
        public String getPath() {
            return "/new-company";
        }
    },
    EDIT {
        @Override
        public String getPath() {
            return "/edit-company";
        }
    },
    DELETE {
        @Override
        public String getPath() {
            return "/delete-company";
        }
    },
    FORM {
        @Override
        public String getPath() {
            return "/company-form";
        }
    };

}
