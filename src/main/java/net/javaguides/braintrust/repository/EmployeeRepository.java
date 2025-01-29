package net.javaguides.braintrust.repository;

import net.javaguides.braintrust.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
