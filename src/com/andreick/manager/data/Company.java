package com.andreick.manager.data;

import java.util.Date;

public class Company {

    private long id;
    private String name;
    private Date startDate;

    public Company(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public String getName() {
        return this.name;
    }

    public Date getStartDate() {
        return startDate;
    }

}
