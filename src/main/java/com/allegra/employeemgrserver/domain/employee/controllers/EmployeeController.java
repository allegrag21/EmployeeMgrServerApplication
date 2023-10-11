package com.allegra.employeemgrserver.domain.employee.controllers;


import com.allegra.employeemgrserver.domain.core.exceptions.ResourceCreationException;
import com.allegra.employeemgrserver.domain.employee.models.Employee;
import com.allegra.employeemgrserver.domain.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//everything starts off in spring with a component and a bean
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees") // prefix for our mapping - employee controller
@CrossOrigin("*") // any request can come in
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired // we need something that can satisfy this need. STOP
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employees = employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) throws ResourceCreationException {
        employee = employeeService.create(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") Long id){
        Employee employee = employeeService.getById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<Employee> getByEmail(@RequestParam String email){
        Employee employee = employeeService.getByEmail(email);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") Long id, @RequestBody Employee employeeDetail){
        employeeDetail = employeeService.update(id, employeeDetail);
        return new ResponseEntity<>(employeeDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        employeeService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}