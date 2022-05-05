package com.cognizant.reactintegration.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.reactintegration.model.Employee;
import com.cognizant.reactintegration.repository.EmployeeRepository;
import com.cognizant.reactintegration.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getEmployee(){
		return employeeRepository.findAll();
	}
	@Override
	public Employee addEmployee(Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}
	@Override
	public Employee deleteEmployee(int id) {
		Employee emp=employeeRepository.findById(id).get();
		employeeRepository.deleteById(id);
		return emp;
	}
	@Override
	public Employee updateEmployee(Employee employee, int id) {
		Optional<Employee> optEmp=employeeRepository.findById(id);
		if(!optEmp.isPresent()) {
			throw new RuntimeException("Employee with Id"+id+"doesnot exist");
		}
		Employee emp=optEmp.get();
		if(employee.getName()!=null) {
			emp.setName(employee.getName());
		}
		if(employee.getGender()!=null) {
			emp.setGender(employee.getGender());
		}
		if(employee.getAge()!=0) {
			emp.setAge(employee.getAge());
		}
		if(employee.getSalary()!=0) {
			emp.setSalary(employee.getSalary());
		}
		employeeRepository.save(emp);
		return emp;
	}
	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee with Id"+id+"doesnot exist"));
	}
	@Override
	public Employee updateEmployee(int id, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}
}
	
	
	

	


