package net.javaguides.braintrust.dto;

import lombok.*;
import net.javaguides.braintrust.entity.Department;
import net.javaguides.braintrust.entity.ProjectAssignment;
import net.javaguides.braintrust.entity.RoleAssignment;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private long id;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private double salary;
    private LocalDate hireDate;
    private String email;
    private String mobileNumber;
    private RoleAssignment roleAssignment;
    private ProjectAssignment projectAssignment;
}
