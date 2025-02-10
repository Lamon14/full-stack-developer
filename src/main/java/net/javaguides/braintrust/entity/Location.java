package net.javaguides.braintrust.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn (name = "fk_location_id", referencedColumnName = "id")
    private Set<Department> departments;

}
