package com.almousleck.apiapplication.resource;

import com.almousleck.apiapplication.model.Employee;
import com.almousleck.apiapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/employees")
public class EmployeeResource {


    private final EmployeeService employeeService;

    public EmployeeResource(@Qualifier(value = "myDBEmployeeService") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> findEmployee(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
       // employee.setId(employeeService.getEmployees().size() + 1);
        return ResponseEntity.created(getLocation(employee.getId())).body(employeeService.addEmployee(employee));
    }
    protected static URI getLocation(Integer id) {
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}").buildAndExpand(id).toUri();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @RequestBody Employee employee,
            @PathVariable("id") Integer id) {
       employee.setId(id);
       return new ResponseEntity<>(employeeService.updateEmployee(employee),
               HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Integer id) {
        //return ResponseEntity.ok(employeeService.deleteById(id));
        employeeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
