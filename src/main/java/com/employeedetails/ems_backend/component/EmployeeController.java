package com.employeedetails.ems_backend.component;
import com.employeedetails.ems_backend.dto.EmployeeDto;
import com.employeedetails.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping ("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //Build Add Employee Rest Api
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
      EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee Rest Api
    @GetMapping("{id}")
    public ResponseEntity<Optional<EmployeeDto>> getEmployeeById(@PathVariable("id") Long employeeId){
        Optional<EmployeeDto> employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //Build Get All Employee Rest Api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build update Employee Rest Api
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto>updateEmployee(@PathVariable("id") Long employeeId,
                                                    @RequestBody EmployeeDto updatedEmployee){
            EmployeeDto employeeDto= employeeService.updateEmployee(employeeId, updatedEmployee);
            return ResponseEntity.ok(employeeDto);
    }

    //Build delete Employee Rest Api
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
            employeeService.deleteEmployee(employeeId);
            return ResponseEntity.ok("Employee deleted successfully!.");
    }

}
