package com.example.model;

import java.util.List;

public class Employee {
    private String name;
    private List<String> books;
    private List<String> roles;

    public Employee(String name, List<String> books, List<String> roles) {
        this.name = name;
        this.books = books;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public List<String> getBooks() {
        return books;
    }

    public List<String> getRoles() {
        return roles;
    }
}
