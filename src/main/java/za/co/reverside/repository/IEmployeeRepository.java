package za.co.reverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.model.Employee;

import java.util.Collection;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long>
{
  Employee getEmployeeByFirstName(String firstName);

  Collection<Employee> getEmployeeByLastName(String lastName);
}
