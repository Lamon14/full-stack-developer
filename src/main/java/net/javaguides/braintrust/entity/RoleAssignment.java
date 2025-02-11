package net.javaguides.braintrust.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role_assignment")
public class RoleAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "assignment_date")
    private LocalDate assignmentDate;
}
