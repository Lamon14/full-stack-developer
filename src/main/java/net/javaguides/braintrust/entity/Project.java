package net.javaguides.braintrust.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "type")
    private String type;

    @Column(name = "startdate")
    private Date date;

    @Column(name = "duration")
    private String duration;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "fk_project_id", referencedColumnName = "id")
    private Set<ProjectAssignment> projectAssignment;
}
