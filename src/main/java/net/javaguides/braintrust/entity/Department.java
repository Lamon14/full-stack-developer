package net.javaguides.braintrust.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private long id;

    @Column(name = "department_name")
    private String departmentName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "fk_department_id", referencedColumnName = "department_id")
    private List<Employee> employees;

}
