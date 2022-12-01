package com.almousleck.apiapplication.service;

import com.almousleck.apiapplication.model.Employee;
import java.util.List;

public interface EmployeeService {

    // Save an Employee
    Employee addEmployee(Employee employee);

    // Get Employees
    List<Employee> getEmployees();

    // Get One Employee
    Employee findById(Integer id);

    // Update Employee
    Employee updateEmployee(Employee employee);

    // Delete Employee
    Boolean deleteById(Integer id);
}
