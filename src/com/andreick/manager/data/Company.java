package com.andreick.manager.data;

public class Company {

    private long id;
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
