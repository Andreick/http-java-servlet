package com.andreick.manager.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FakeDatabase {

    private static Long sequentialId = 0L;
    private static List<Company> companies = new ArrayList<>();
    private static List<User> users = new ArrayList<>();

    static {
        companies.add(new Company(++sequentialId, "Alura", new Date()));
        companies.add(new Company(++sequentialId, "Caelum", new Date()));

        users.add(new User("root", "123"));
        users.add(new User("user", "123"));
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

    public User getAuthenticatedUser(String login, String password) {
        for (User user : users) {
            if (user.authenticate(login, password)) {
                return user;
            }
        }
        return null;
    }

}
