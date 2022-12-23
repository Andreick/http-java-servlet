package com.andreick.manager.controller.route.company;

import com.andreick.manager.controller.route.Route;

public enum CompanyRoute implements Route {

    LIST {
        @Override
        public String getUrl() {
            return "/list-companies";
        }
    },
    SHOW {
        @Override
        public String getUrl() {
            return "/show-company";
        }
    },
    NEW {
        @Override
        public String getUrl() {
            return "/new-company";
        }
    },
    EDIT {
        @Override
        public String getUrl() {
            return "/edit-company";
        }
    },
    DELETE {
        @Override
        public String getUrl() {
            return "/delete-company";
        }
    },
    FORM {
        @Override
        public String getUrl() {
            return "/company-form";
        }
    };

}
