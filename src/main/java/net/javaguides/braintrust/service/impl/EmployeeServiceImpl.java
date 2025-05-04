package net.javaguides.braintrust.service.impl;

import net.javaguides.braintrust.dto.EmployeeDto;
import net.javaguides.braintrust.entity.Employee;
import net.javaguides.braintrust.exceptionhandler.ResourceNotFoundException;
import net.javaguides.braintrust.mapper.EmployeeMapper;
import net.javaguides.braintrust.repository.EmployeeRepository;
import net.javaguides.braintrust.service.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {

        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.mapToEmployee(employeeDto);
        return employeeMapper.mapToEmployeeDto(employeeRepository.save(employee));
    }
    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("Employee does not exist"));
        return employeeMapper.mapToEmployeeDto(employee);
    }
    @Override
    public List<EmployeeDto> getAllEmployees() {
        logger.info("We are starting by finding all employees");
        List<Employee> employees = employeeRepository.findAll();
        logger.info("We are returning all employees");
        return employees.stream().map(employeeMapper::mapToEmployeeDto)
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
        employee.setSalary(updatedEmployee.getSalary());
        employee.setHireDate(updatedEmployee.getHireDate());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setMobileNumber(updatedEmployee.getMobileNumber());

        Employee updatedEmployeeObj = employeeRepository.save(employee);
        return employeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }
}
