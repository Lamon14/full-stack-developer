package net.javaguides.braintrust.service.impl;

import net.javaguides.braintrust.dto.EmployeeDto;
import net.javaguides.braintrust.entity.Employee;
import net.javaguides.braintrust.exceptionhandler.ResourceNotFoundException;
import net.javaguides.braintrust.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;

    private EmployeeDto employeeDto;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setId(1L);
        employee.setFirstName("John");
        employee.setLastName("Smith");
        employee.setEmail("john.smith@gmail.com");
        employee.setJobTitle("Developer");
        employee.setSalary(5000.0);
        employee.setMobileNumber("1234567890");
        employee.setHireDate(LocalDate.now());

        employeeDto = new EmployeeDto();
        employeeDto.setId(1L);
        employeeDto.setFirstName("John");
        employeeDto.setLastName("Smith");
        employeeDto.setEmail("john.smith@gmail.com");
        employeeDto.setJobTitle("Developer");
        employeeDto.setSalary(5000.0);
        employeeDto.setMobileNumber("1234567890");
        employeeDto.setHireDate(LocalDate.now());
    }

    @Test
    void testCreateEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        EmployeeDto result = employeeService.createEmployee(employeeDto);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Smith", result.getLastName());
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

    @Test
    void testGetEmployeeById() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        EmployeeDto result = employeeService.getEmployeeById(1L);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Smith", result.getLastName());
        verify(employeeRepository, times(1)).findById(1L);
    }

    @Test
    void testGetEmployeeById_NotFound() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () ->{
                    employeeService.getEmployeeById(1L);
                });

        assertEquals("Resource not found", "Resource not found");
    }

    @Test
    void testGetAllEmployees() {
        List<Employee> employees = List.of(employee);
        when(employeeRepository.findAll()).thenReturn(employees);

        List<EmployeeDto> result = employeeService.getAllEmployees();
        assertEquals(1, result.size());
        assertEquals("John", result.getFirst().getFirstName());
    }

    @Test
    void testDeleteEmployee() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        employeeService.deleteEmployee(1L);

        verify(employeeRepository, times(1)).delete(employee);
    }

    @Test
    void testDeleteEmployee_NotFound() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> {
            employeeService.deleteEmployee(1L);
        });

        assertEquals("Employee with id 1 not found","Employee with id 1 not found");
    }

    @Test
    void testUpdateEmployee() {
        EmployeeDto updateDto = new EmployeeDto();
        updateDto.setFirstName("John");
        updateDto.setLastName("Smith");
        updateDto.setEmail("john.smith@gmail.com");
        updateDto.setJobTitle("Senior Dev");
        updateDto.setSalary(6000.0);
        updateDto.setMobileNumber("9876543210");
        updateDto.setHireDate(LocalDate.of(2020, 5, 1));

        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        EmployeeDto result = employeeService.updateEmployee(1L, updateDto);

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Senior Dev", employee.getJobTitle());
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testUpdateEmployee_NotFound() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.empty());

        EmployeeDto updatedDto = new EmployeeDto();
        updatedDto.setFirstName("John");

        assertThrows(ResourceNotFoundException.class, () -> {
            employeeService.updateEmployee(1L, updatedDto);
        });
    }
}