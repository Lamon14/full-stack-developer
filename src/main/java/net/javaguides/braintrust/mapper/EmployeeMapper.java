package net.javaguides.braintrust.mapper;

import net.javaguides.braintrust.dto.EmployeeDto;
import net.javaguides.braintrust.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public Employee mapToEmployee(EmployeeDto employeeDto){
        if (employeeDto == null) return null;

        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setJobTitle(employeeDto.getJobTitle());
        employee.setSalary(employeeDto.getSalary());
        employee.setHireDate(employeeDto.getHireDate());
        employee.setEmail(employeeDto.getEmail());
        employee.setMobileNumber(employeeDto.getMobileNumber());

        return employee;
    }

    public EmployeeDto mapToEmployeeDto(Employee employee){
        if (employee == null) return null;

        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setJobTitle(employee.getJobTitle());
        dto.setSalary(employee.getSalary());
        dto.setHireDate(employee.getHireDate());
        dto.setEmail(employee.getEmail());
        dto.setMobileNumber(employee.getMobileNumber());

        return dto;
    }
}
