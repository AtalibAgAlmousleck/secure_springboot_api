package com.almousleck.apiapplication.repository;

import com.almousleck.apiapplication.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryEmployeeRepository {

    private static final List<Employee> DATABASE = new ArrayList<>();

    static {
        DATABASE.add(new Employee(1, "Mohamed Ag", "Almousleck", "atalib@gmail.com"));
        DATABASE.add(new Employee(2, "Hamdi Ag", "Anara", "hamdi@gmail.com"));
        DATABASE.add(new Employee(3, "Mark Ag", "Alba", "mark@gmail.com"));
        DATABASE.add(new Employee(4, "Aziz", "Toure", "toure@gmail.com"));
    }

    // Save an Employee
    public Employee addEmployee(Employee employee) {
        DATABASE.add(employee);
        return employee;
    }

    // Get Employees
    public List<Employee> getEmployees() {
        return List.copyOf(DATABASE);
    }

    // Get One Employee
    public Employee findById(Integer id) {
        return DATABASE.stream()
                .filter(employee -> id.equals(employee.getId()))
                .findFirst()
                .orElseThrow();
    }

    // Update Employee
    public Employee updateEmployee(Employee employee) {
        DATABASE.add(employee);
        return employee;
    }

    // Delete Employee
    public Boolean deleteById(Integer id) {
        Employee employee = DATABASE.stream()
                .filter(employee1 -> id.equals(employee1.getId()))
                .findFirst().orElseThrow();
        DATABASE.remove(employee);
        return Boolean.TRUE;
    }
}
