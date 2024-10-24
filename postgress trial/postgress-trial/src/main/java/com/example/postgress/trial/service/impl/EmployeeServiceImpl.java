package com.example.postgress.trial.service.impl;

import com.example.postgress.trial.dto.EmployeeDto;
import com.example.postgress.trial.entity.Employee;
import com.example.postgress.trial.exception.ResourceNotFound;
import com.example.postgress.trial.mapper.EmployeeMapper;
import com.example.postgress.trial.repository.EmployeeRepository;
import com.example.postgress.trial.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapTOEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeByID(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFound("Employee does not exist with id: " + employeeId));
        return EmployeeMapper.mapTOEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapTOEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFound("Employee does not exist with id: " + employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeobj = employeeRepository.save(employee);
        return EmployeeMapper.mapTOEmployeeDto(updatedEmployeeobj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFound("Employee does not exist with id: " + employeeId));
        employeeRepository.deleteById(employeeId);

    }
}
