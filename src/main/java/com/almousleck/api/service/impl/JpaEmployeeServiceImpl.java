package com.almousleck.apiapplication.service.impl;

import com.almousleck.apiapplication.model.Employee;
import com.almousleck.apiapplication.repository.EmployeeRepository;
import com.almousleck.apiapplication.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Qualifier(value = "myDBEmployeeService")
public class JpaEmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Boolean deleteById(Integer id) {
        employeeRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
