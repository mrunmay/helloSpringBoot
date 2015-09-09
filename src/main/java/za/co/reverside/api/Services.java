package za.co.reverside.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.reverside.model.Employee;
import za.co.reverside.repository.IEmployeeRepository;

import java.util.Collection;

@RestController
@RequestMapping(value = "api/")
public class Services
{
  @Autowired
  IEmployeeRepository employeeRepository;

  @RequestMapping(value = "employee/{id}", method = RequestMethod.GET, produces = "application/json")
  public Employee getEmployee(@PathVariable("id") Long id)
  {
    Employee employee = employeeRepository.findOne(id);
    if (employee == null)
    {
      throw new RuntimeException("User not found.");
    }
    return employee;
  }

  @RequestMapping(value = "employees", method = RequestMethod.GET, produces = "application/json")
  public Collection<Employee> getEmployees()
  {
    return employeeRepository.findAll();
  }

  @RequestMapping(value = "employee/fname/{firstName}", method = RequestMethod.GET, produces = "application/json")
  public Employee getEmployeeByFirstName(@PathVariable("firstName") String firstName)
  {
    return employeeRepository.getEmployeeByFirstName(firstName);
  }

  @RequestMapping(value = "employee/lname/{lastName}", method = RequestMethod.GET, produces = "application/json")
  public Collection<Employee> getEmployeeByLastName(@PathVariable("lastName") String LastName)
  {
    return employeeRepository.getEmployeeByLastName(LastName);
  }

  @RequestMapping(value = "employee/delete/{id}")
  public void getRemoveEmployeeById(@PathVariable("id") Long id)
  {
    Employee employee = employeeRepository.findOne(id);
    if (employee == null)
    {
      throw new RuntimeException("User doesn't Exist.");
    }
    employeeRepository.delete(id);
  }

}
