package com.bridgelabz.employeepayrollapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EmployeePayrollData {
    
    @Id
    private int id;
    private String name;
    private double salary;

    // Constructors
    public EmployeePayrollData() {}

    public EmployeePayrollData(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
