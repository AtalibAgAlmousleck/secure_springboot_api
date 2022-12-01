package com.almousleck.apiapplication.service.impl;

import com.almousleck.apiapplication.model.Employee;
import com.almousleck.apiapplication.repository.InMemoryEmployeeRepository;
import com.almousleck.apiapplication.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Qualifier(value = "inMemory")
public class InMemoryEmployeeServiceImpl implements EmployeeService {

    private final InMemoryEmployeeRepository inMemoryEmployeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
       return inMemoryEmployeeRepository.addEmployee(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return inMemoryEmployeeRepository.getEmployees();
    }

    @Override
    public Employee findById(Integer id) {
        return inMemoryEmployeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
       return inMemoryEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return inMemoryEmployeeRepository.deleteById(id);
    }
}
