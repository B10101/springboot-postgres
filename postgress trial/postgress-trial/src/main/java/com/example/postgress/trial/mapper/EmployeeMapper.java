package com.example.postgress.trial.mapper;

import com.example.postgress.trial.dto.EmployeeDto;
import com.example.postgress.trial.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapTOEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
