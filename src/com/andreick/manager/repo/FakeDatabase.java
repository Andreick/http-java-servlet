package com.andreick.manager.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.andreick.manager.data.Company;

public class FakeDatabase {

    private static List<Company> companies = new ArrayList<>();
    private static Long sequentialId = 0L;

    static {
        Company c1 = new Company(++sequentialId, "Alura", new Date());
        Company c2 = new Company(++sequentialId, "Caelum", new Date());
        companies.add(c1);
        companies.add(c2);
    }

    public List<Company> getCompanies() {
        return Collections.unmodifiableList(companies);
    }

    public Company getCompanyById(int id) {
        for (Company company : companies) {
            if (company.getId() == id) {
                return company;
            }
        }
        return null;
    }

    public Long create(Company company) {
        Company newCompany = new Company(++sequentialId, company);
        companies.add(newCompany);
        return sequentialId;
    }

    public int update(Company updatedCompany) {
        int numUpdated = 0;
        for (int i = 0; i < companies.size(); i++) {
            Company company = companies.get(i);
            if (company.getId() == updatedCompany.getId()) {
                companies.set(i, updatedCompany);
                numUpdated++;
                break;
            }
        }
        return numUpdated;
    }

    public int deleteCompanyById(int id) {
        int numDeleted = 0;
        for (Iterator<Company> iterator = companies.iterator(); iterator.hasNext();) {
            Company company = (Company) iterator.next();
            if (company.getId() == id) {
                iterator.remove();
                numDeleted++;
                break;
            }
        }
        return numDeleted;
    }

}
