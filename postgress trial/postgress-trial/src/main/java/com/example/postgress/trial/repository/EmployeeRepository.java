package com.example.postgress.trial.repository;

import com.example.postgress.trial.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
