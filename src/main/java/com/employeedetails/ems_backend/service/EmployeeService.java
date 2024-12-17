package com.employeedetails.ems_backend.service;
import com.employeedetails.ems_backend.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    Optional<EmployeeDto> getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeId);
}
