package net.javaguides.braintrust.dto;

import lombok.*;
import java.time.LocalDate;
import java.util.List;

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
    private List<RoleAssignmentDTO> roleAssignment;
    private List<ProjectAssignmentDTO> projectAssignments;
}
