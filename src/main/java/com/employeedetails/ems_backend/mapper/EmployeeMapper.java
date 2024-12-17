package com.employeedetails.ems_backend.mapper;

import com.employeedetails.ems_backend.dto.EmployeeDto;
import com.employeedetails.ems_backend.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto (Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastname(),
                employee.getEmail(),
                employee.getPassword()
        );
    }
    public static Employee mapToEmployee (EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getPassword()
        );
    }
}
