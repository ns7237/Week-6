package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        Optional<EmployeePayrollData> employeeData = employeeRepository.findById(empId);
        return employeeData.orElse(null);
    }

    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empDTO) {
        EmployeePayrollData data = this.getEmployeePayrollDataById(empId);
        if (data != null) {
            data.setName(empDTO.getName());
            data.setSalary(empDTO.getSalary());
            return employeeRepository.save(data);
        }
        return null;
    }
}
