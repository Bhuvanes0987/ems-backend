package com.employeedetails.ems_backend.service.impl;
import com.employeedetails.ems_backend.dto.EmployeeDto;
import com.employeedetails.ems_backend.entity.Employee;
import com.employeedetails.ems_backend.exception.ResourceNotFoundException;
import com.employeedetails.ems_backend.mapper.EmployeeMapper;
import com.employeedetails.ems_backend.repository.EmployeeRepository;
import com.employeedetails.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class    EmployeeServiceImpl  implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee SavedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(SavedEmployee);
    }

    @Override
    public Optional<EmployeeDto> getEmployeeById(Long employeeId) {
        Employee employee= employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Employee is not exist with the given id :" + employeeId));
        return Optional.of(EmployeeMapper.mapToEmployeeDto(employee));
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException("Employee not exist with the given id: "+employeeId ));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastname(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setPassword(updatedEmployee.getPassword());

         Employee updatedEmployeeObj = employeeRepository.save(employee);
         return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(()->
                new ResourceNotFoundException("Employee not exist with the given id: "+employeeId ));
                       employeeRepository.deleteById(employeeId);

    }


}

