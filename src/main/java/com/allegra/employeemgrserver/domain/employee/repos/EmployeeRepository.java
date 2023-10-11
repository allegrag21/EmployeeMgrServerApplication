package com.allegra.employeemgrserver.domain.employee.repos;

import com.allegra.employeemgrserver.domain.employee.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmail(String email);
}

