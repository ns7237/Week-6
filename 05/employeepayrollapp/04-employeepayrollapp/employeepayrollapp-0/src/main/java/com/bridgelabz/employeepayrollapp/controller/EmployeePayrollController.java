package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    // Dummy data for demo
    private static Map<Long, Employee> employeeData = new HashMap<>();

    static {
        employeeData.put(1L, new Employee(1L, "Anusha N", "Engineering"));
        employeeData.put(2L, new Employee(2L, "Raj Kumar", "HR"));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {
        Employee emp = employeeData.get(id);
        if (emp != null) {
            return ResponseEntity.ok(emp);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Employee not found with id: " + id);
        }
    }
}
