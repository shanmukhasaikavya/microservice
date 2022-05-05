package com.cognizant.reactintegration.controller;





import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.cognizant.reactintegration.model.Employee;
import com.cognizant.reactintegration.service.EmployeeService;



@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/employees")
public class EmployeeResource {

@Autowired
private EmployeeService employeeService;

@GetMapping("/")
public List<Employee> getEmployees(){
return employeeService.getEmployee();
}

@GetMapping("/{id}")
public List<Employee> getEmployeesById(@PathVariable int id){
return (List<Employee>) employeeService.getEmployeeById(id);
}

@PutMapping("/{id}")
public List<Employee> updateEmployees(@PathVariable int id,@RequestBody Employee employee){
return (List<Employee>) employeeService.updateEmployee(id,employee);
}

@PostMapping("/")
public Employee addEmployee(@RequestBody Employee employee) {
return employeeService.addEmployee(employee);
}

@DeleteMapping("/{id}")
public Employee deleteEmployee(@PathVariable int id) {
return employeeService.deleteEmployee(id);
}




}