package net.javaguides.braintrust.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates unique ID
    @Column(name = "employee_id")  // Specify column name
    private long id;

    @Column(name = "first_name", nullable = false)  // Column for first name, cannot be null
    private String firstName;

    @Column(name = "last_name", nullable = false)  // Column for last name, cannot be null
    private String lastName;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "department")
    private String department;

    @Column(name = "salary")
    private double salary;

    @Temporal(TemporalType.DATE)  // Use @Temporal to map java.util.Date to SQL DATE
    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "email", unique = true, nullable = false)  // Column for email, unique and non-null
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

}
