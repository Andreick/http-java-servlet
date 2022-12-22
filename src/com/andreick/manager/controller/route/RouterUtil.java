package com.andreick.manager.controller.route;

import java.util.Arrays;
import java.util.List;

import com.andreick.manager.controller.route.company.CompanyRouter;
import com.andreick.manager.controller.route.login.LoginRouter;

public class RouterUtil {

    public static List<Router> getRouters() {
        return Arrays.asList(new LoginRouter(), new CompanyRouter());
    }

}
