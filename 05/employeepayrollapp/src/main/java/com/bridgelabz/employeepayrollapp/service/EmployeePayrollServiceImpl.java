package com.bridgelabz.employeepayrollapp.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeePayrollServiceImpl implements IEmployeePayrollService {

    @Override
    public String getEmployeeDetails() {
        return "Employee details: John Doe, ID 101, Salary 50000";
    }
}
