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
        actionMap.put(CompanyRoute.LIST.getUrl(), new ListCompanies());
        actionMap.put(CompanyRoute.SHOW.getUrl(), new ShowCompany());
        actionMap.put(CompanyRoute.NEW.getUrl(), new NewCompany());
        actionMap.put(CompanyRoute.EDIT.getUrl(), new EditCompany());
        actionMap.put(CompanyRoute.DELETE.getUrl(), new DeleteCompany());
        actionMap.put(CompanyRoute.FORM.getUrl(), new NewCompanyForm());
    }

}
