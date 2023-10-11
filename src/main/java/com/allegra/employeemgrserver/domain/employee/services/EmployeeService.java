package com.allegra.employeemgrserver.domain.employee.services;

import com.allegra.employeemgrserver.domain.core.exceptions.ResourceCreationException;
import com.allegra.employeemgrserver.domain.core.exceptions.ResourceNotFoundException;
import com.allegra.employeemgrserver.domain.employee.models.Employee;

import java.util.List;

public interface EmployeeService {

    // Declares a method signature to create an Employee. It throws a ResourceCreationException if any issues occur during creation.
    Employee create(Employee employee) throws ResourceCreationException;

    // Declares a method signature to fetch an Employee based on a given ID. It throws a ResourceNotFoundException if the employee is not found.
    Employee getById(Long id) throws ResourceNotFoundException;

    // Declares a method signature to fetch an Employee based on a given email. It throws a ResourceNotFoundException if the employee is not found.
    Employee getByEmail(String email) throws ResourceNotFoundException;

    // Declares a method signature to fetch a list of all employees.
    List<Employee> getAll();

    // Declares a method signature to update an existing Employee based on a given ID and details. It throws a ResourceNotFoundException if the employee is not found.
    Employee update(Long id, Employee employeeDetail) throws ResourceNotFoundException;

    // Declares a method signature to delete an employee based on a given ID.
    void delete(Long id);
}











