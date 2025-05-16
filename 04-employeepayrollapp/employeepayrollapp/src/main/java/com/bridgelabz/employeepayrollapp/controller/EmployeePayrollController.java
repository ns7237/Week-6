package com.bridgelabz.employeepayrollapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Employee Payroll Service";
    }

    @GetMapping("/get/{id}")
    public String getEmployee(@PathVariable int id) {
        return "Employee details for ID: " + id;
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee employee) {
        // save employee logic here
        return "Employee created: " + employee.getName();
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee) {
        // update employee logic here
        return "Employee updated: " + employee.getName();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        // delete employee logic here
        return "Employee deleted with ID: " + id;
    }

    // Employee class for example
    static class Employee {
        private String name;
        private double salary;

        // getters and setters

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public double getSalary() { return salary; }
        public void setSalary(double salary) { this.salary = salary; }
    }
}
