package com.cognizant.reactintegration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.reactintegration.model.Employee;
@Service
public interface EmployeeService {
	List<Employee> getEmployee();
	Employee addEmployee(Employee employee);
	Employee deleteEmployee(int id);
	Employee updateEmployee(int id, Employee employee);
	Employee getEmployeeById(int id);
	Employee updateEmployee(Employee employee, int id);

}
