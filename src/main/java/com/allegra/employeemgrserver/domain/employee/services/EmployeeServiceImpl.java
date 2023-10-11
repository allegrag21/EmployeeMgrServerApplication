package com.allegra.employeemgrserver.domain.employee.services;

import com.allegra.employeemgrserver.domain.core.exceptions.ResourceCreationException;
import com.allegra.employeemgrserver.domain.core.exceptions.ResourceNotFoundException;
import com.allegra.employeemgrserver.domain.employee.models.Employee;
import com.allegra.employeemgrserver.domain.employee.repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Indicates that this class should be automatically discovered by Spring Boot and instantiated as a bean.
@Service
public class EmployeeServiceImpl implements EmployeeService {
    // Private instance variable for the repository class that deals with CRUD operations on the Employee entity.
    private EmployeeRepository employeeRepository;
    // Constructor that takes an instance of EmployeeRepository. The @Autowired annotation is used to auto-wire (automatically provide) the EmployeeRepository bean to this service.
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    // Implements the create method from the EmployeeService interface.
    @Override
    public Employee create(Employee employee) throws ResourceCreationException {
        Optional<Employee> optional = employeeRepository.findByEmail(employee.getEmail()); // Finds an employee by email.
        if(optional.isPresent())
            throw new ResourceCreationException("Employee with email exists: " + employee.getEmail()); // Throws an exception if an employee with the given email already exists.
        return employeeRepository.save(employee); // Saves the new employee to the database and returns the saved entity.
    }
    // Implements the getById method from the EmployeeService interface.
    @Override
    public Employee getById(Long id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id) // Fetches an employee by ID or throws an exception if the employee does not exist.
                .orElseThrow(() -> new ResourceNotFoundException("No Employee with id: " + id));
        return employee;
    }
    // Implements the getByEmail method from the EmployeeService interface.
    @Override
    public Employee getByEmail(String email) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findByEmail(email) // Fetches an employee by email or throws an exception if the employee does not exist.
                .orElseThrow(() -> new ResourceNotFoundException("No Employee with email: " + email));
        return employee;
    }
    // Implements the getAll method from the EmployeeService interface.
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll(); // Fetches all employees from the database.
    }
    // Implements the update method from the EmployeeService interface.
    @Override
    public Employee update(Long id, Employee employeeDetail) throws ResourceNotFoundException {
        Employee employee = getById(id); // Fetches the existing employee by ID.
        employee.setFirstName(employeeDetail.getFirstName());// Updates the employee's details.
        employee.setLastName(employeeDetail.getLastName());
        employee.setEmail(employeeDetail.getEmail());
        employee = employeeRepository.save(employee);
        return employee;
    }
    // Implements the delete method from the EmployeeService interface.
    @Override
    public void delete(Long id) {
        Employee employee = getById(id); // Fetches the existing employee by ID.
        employeeRepository.delete(employee); // Deletes the employee from the database.
    }
}
