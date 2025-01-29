package net.javaguides.braintrust.dto;

import lombok.*;

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
    private String department;
    private double salary;
    private LocalDate hireDate;
    private String email;
    private String mobileNumber;
}
