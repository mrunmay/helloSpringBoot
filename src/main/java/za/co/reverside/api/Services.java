package za.co.reverside.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import za.co.reverside.model.Employee;
import za.co.reverside.repository.IEmployeeRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping(value = "api/")
public class Services
{
  @Autowired
  IEmployeeRepository employeeRepository;

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  @ResponseStatus( HttpStatus.CREATED )
  public void addNewEmployee(@RequestBody Employee employee)
  {
    if (employee != null) {
      employeeRepository.save(employee);
    }
  }

  @RequestMapping(value = "employee/{id}", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus( HttpStatus.OK )
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
  @ResponseStatus( HttpStatus.OK )
  public Collection<Employee> getEmployees()
  {
    return employeeRepository.findAll();
  }

  @RequestMapping(value = "employee/fname/{firstName}", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus( HttpStatus.OK )
  public Employee getEmployeeByFirstName(@PathVariable("firstName") String firstName)
  {
    return employeeRepository.getEmployeeByFirstName(firstName);
  }

  @RequestMapping(value = "employee/lname/{lastName}", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus( HttpStatus.OK )
  public Collection<Employee> getEmployeeByLastName(@PathVariable("lastName") String LastName)
  {
    return employeeRepository.getEmployeeByLastName(LastName);
  }

  @RequestMapping(value = "employee/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
  @ResponseStatus( HttpStatus.OK )
  public void deleteEmployeeById(@PathVariable("id") Long id)
  {
    Employee employee = employeeRepository.findOne(id);
    if (employee == null)
    {
      throw new RuntimeException("User doesn't Exist.");
    }
    employeeRepository.delete(id);
  }

  @RequestMapping(value = "employee/delete/all", method = RequestMethod.DELETE, produces = "application/json")
  @ResponseStatus( HttpStatus.OK)
  public void deleteEmployees()
  {
    List<Employee> employees = employeeRepository.findAll();
    if (employees == null || employees.isEmpty())
    {
      throw new RuntimeException("No User Exist.");
    }
    employeeRepository.deleteAll();
  }

  @RequestMapping(path = "/build", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus( HttpStatus.OK)
  public Properties build() throws IOException
  {
    InputStream in = new ClassPathResource("git.properties").getInputStream();
    Properties properties = new Properties();
    properties.load(in);
    return properties;
  }
}
