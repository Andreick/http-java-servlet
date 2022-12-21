package com.andreick.manager.controller.route.company;

import java.util.Map;

import com.andreick.manager.controller.action.Action;
import com.andreick.manager.controller.action.company.DeleteCompany;
import com.andreick.manager.controller.action.company.EditCompany;
import com.andreick.manager.controller.action.company.ListCompanies;
import com.andreick.manager.controller.action.company.NewCompany;
import com.andreick.manager.controller.action.company.NewCompanyForm;
import com.andreick.manager.controller.action.company.ShowCompany;
import com.andreick.manager.controller.route.Router;

public class CompanyRouter implements Router {

    @Override
    public void putActions(Map<String, Action> actionMap) {

        actionMap.put(CompanyRoute.LIST.getPath(), new ListCompanies());
        actionMap.put(CompanyRoute.SHOW.getPath(), new ShowCompany());
        actionMap.put(CompanyRoute.NEW.getPath(), new NewCompany());
        actionMap.put(CompanyRoute.EDIT.getPath(), new EditCompany());
        actionMap.put(CompanyRoute.DELETE.getPath(), new DeleteCompany());
        actionMap.put(CompanyRoute.FORM.getPath(), new NewCompanyForm());
    }

}
