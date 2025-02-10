package net.javaguides.braintrust.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "fk_department_id", referencedColumnName = "department_id")
    private Set<Employee> employees;

}
