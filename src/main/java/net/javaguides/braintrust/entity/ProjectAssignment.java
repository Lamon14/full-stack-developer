package net.javaguides.braintrust.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
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

    @Column(name = "date", insertable=false, updatable=false)
    private Date date;
}
