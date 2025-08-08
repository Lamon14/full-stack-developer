package net.javaguides.braintrust.mapper;

import net.javaguides.braintrust.dto.EmployeeDto;
import net.javaguides.braintrust.dto.ProjectAssignmentDto;
import net.javaguides.braintrust.dto.RoleAssignmentDto;
import net.javaguides.braintrust.entity.Employee;
import net.javaguides.braintrust.entity.ProjectAssignment;
import net.javaguides.braintrust.entity.RoleAssignment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

        if (employeeDto.getRoleAssignment() != null) {
            List<RoleAssignment> roles = employeeDto.getRoleAssignment().stream()
                    .map(r -> new RoleAssignment(r.getId(), r.getAssignmentDate()))
                    .collect(Collectors.toList());
            employee.setRoleAssignment(roles);
        }

        if (employeeDto.getProjectAssignments() != null) {
            List<ProjectAssignment> projects = employeeDto.getProjectAssignments().stream()
                    .map(p -> {
                        ProjectAssignment pa = new ProjectAssignment();
                        pa.setId(p.getId());
                        pa.setProjectAssignmentName(p.getProjectAssignmentName());
                        pa.setDate(p.getDate());
                        return pa;
                    })
                    .collect(Collectors.toList());
            employee.setProjectAssignments(projects);
        }

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

        if (employee.getRoleAssignment() != null) {
            List<RoleAssignmentDto> roles = employee.getRoleAssignment().stream()
                    .map(r -> new RoleAssignmentDto(r.getId(), r.getAssignmentDate()))
                    .collect(Collectors.toList());
            dto.setRoleAssignment(roles);
        }

        if (employee.getProjectAssignments() != null) {
            List<ProjectAssignmentDto> projects = employee.getProjectAssignments().stream()
                    .map(p -> new ProjectAssignmentDto(p.getId(), p.getProjectAssignmentName(), p.getDate()))
                    .collect(Collectors.toList());
            dto.setProjectAssignments(projects);
        }

        return dto;
    }
}
