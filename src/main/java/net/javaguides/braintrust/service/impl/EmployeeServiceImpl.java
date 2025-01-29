package net.javaguides.braintrust.service.impl;

import net.javaguides.braintrust.dto.EmployeeDto;
import net.javaguides.braintrust.entity.Employee;
import net.javaguides.braintrust.exceptionhandler.ResourceNotFoundException;
import net.javaguides.braintrust.mapper.EmployeeMapper;
import net.javaguides.braintrust.repository.EmployeeRepository;
import net.javaguides.braintrust.service.EmployeeService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }
    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Employee does not exist"));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }
    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Employee does not exists"));
        employeeRepository.delete(employee);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee doesn't exist with given id: " + id)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setJobTitle(updatedEmployee.getJobTitle());
        employee.setDepartment(updatedEmployee.getDepartment());
        employee.setSalary(updatedEmployee.getSalary());
        employee.setHireDate(updatedEmployee.getHireDate());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setMobileNumber(updatedEmployee.getMobileNumber());

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }
}
