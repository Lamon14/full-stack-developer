package net.javaguides.braintrust.controller;

import lombok.AllArgsConstructor;
import net.javaguides.braintrust.dto.EmployeeDto;
import net.javaguides.braintrust.exceptionhandler.ResourceNotFoundException;
import net.javaguides.braintrust.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    // Get Employee REST API
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long id){
        EmployeeDto employeeDto = employeeService.getEmployeeById(id);
        if (employeeDto == null){
            throw new ResourceNotFoundException("Employee is not found with ID: " + id);
        }
        return ResponseEntity.ok(employeeDto);
    }

    // Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllAccounts(){
        List<EmployeeDto> accounts = employeeService.getAllEmployees();
        return ResponseEntity.ok(accounts);
    }

    // Delete Employee REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Account is deleted successfully!");
    }

    // Updating Employee by id REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long id,
                                                      @RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto employeeDto = employeeService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }
}
