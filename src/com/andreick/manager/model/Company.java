package com.andreick.manager.model;

import java.util.Date;

public class Company {

    private Long id;
    private String name;
    private Date startDate;

    public Company(Long id, String name, Date startDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
    }

    public Company(String name, Date startDate) {
        this(null, name, startDate);
    }

    public Company(Long id, Company company) {
        this(company.name, new Date(company.startDate.getTime()));
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Date getStartDate() {
        return startDate;
    }

}
