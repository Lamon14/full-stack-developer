package net.javaguides.braintrust.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project_assigment")
public class ProjectAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates unique ID
    @Column(name = "id")  // Specify column name
    private long id;

    @Column(name = "projectassignment_name", insertable=false, updatable=false)
    private String projectAssignmentName;

    @Temporal(TemporalType.DATE)
    @Column(name = "date", insertable=false, updatable=false)
    private LocalDate date;
}
