package net.javaguides.braintrust.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "salary")
    private double salary;

    @Temporal(TemporalType.DATE)
    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @OneToMany
    @JoinColumn (name = "fk_employee_id", referencedColumnName = "id")
    private List<RoleAssignment> roleAssignment;

    @OneToMany
    @JoinColumn (name = "fk_employee_id", referencedColumnName = "id")
    private List<ProjectAssignment> projectAssignments;

    public Employee(long id, String firstName, String lastName, String jobTitle, double salary, LocalDate hireDate, String email, String mobileNumber) {
    }
}
