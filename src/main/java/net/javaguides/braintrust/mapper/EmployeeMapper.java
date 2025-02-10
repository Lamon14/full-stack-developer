package net.javaguides.braintrust.mapper;

import lombok.Data;
import net.javaguides.braintrust.dto.EmployeeDto;
import net.javaguides.braintrust.entity.Employee;
import net.javaguides.braintrust.entity.ProjectAssignment;
import net.javaguides.braintrust.entity.RoleAssignment;

import java.util.List;
import java.util.Set;

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
                employeeDto.getMobileNumber(),
                (Set<RoleAssignment>) employeeDto.getRoleAssignment(),
                (Set<ProjectAssignment>) employeeDto.getProjectAssignment()

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
                employee.getMobileNumber(),
                (RoleAssignment) employee.getRoleAssignment(),
                (ProjectAssignment) employee.getProjectAssignments()
        );
    }
}
