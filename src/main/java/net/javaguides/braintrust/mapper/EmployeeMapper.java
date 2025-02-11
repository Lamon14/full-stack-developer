package net.javaguides.braintrust.mapper;

import net.javaguides.braintrust.dto.EmployeeDto;
import net.javaguides.braintrust.entity.Employee;


public class EmployeeMapper {

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getJobTitle(),
                employeeDto.getSalary(),
                employeeDto.getHireDate(),
                employeeDto.getEmail(),
                employeeDto.getMobileNumber()
        );
    }

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle(),
                employee.getSalary(),
                employee.getHireDate(),
                employee.getEmail(),
                employee.getMobileNumber()
        );
    }
}
