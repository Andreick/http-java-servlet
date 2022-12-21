package com.andreick.manager.controller.route;

import java.util.Arrays;
import java.util.List;

import com.andreick.manager.controller.route.company.CompanyRouter;

public class RouterUtil {

    public static List<Router> getRouters() {
        return Arrays.asList(new CompanyRouter());
    }

}
