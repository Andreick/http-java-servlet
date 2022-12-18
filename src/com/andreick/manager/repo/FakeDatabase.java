package com.andreick.manager.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.andreick.manager.data.Company;

public class FakeDatabase {

    private static List<Company> companies = new ArrayList<>();

    static {
        Company c1 = new Company("Alura");
        Company c2 = new Company("Caelum");
        companies.add(c1);
        companies.add(c2);
    }

    public List<Company> getCompanies() {
        return Collections.unmodifiableList(companies);
    }

    public void add(Company newCompany) {
        companies.add(newCompany);
    }

}
