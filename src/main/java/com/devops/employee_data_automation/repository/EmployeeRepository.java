package com.devops.employee_data_automation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devops.employee_data_automation.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}