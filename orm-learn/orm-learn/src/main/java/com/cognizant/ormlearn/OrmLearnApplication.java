package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
@SpringBootApplication
@ComponentScan(basePackages = {"com.cognizant.ormlearn, com.cognizant.ormlearn.controller, com.cognizant.ormlearn.model, com.cognizant.ormlearn.repository, com.cognizant.ormlearn.service"})
public class OrmLearnApplication {
	private static CountryService countryService;
	public static EmployeeService employeeService;
	public static DepartmentService departmentService;
	public static SkillService skillService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	@Autowired
	public StockRepository repository;
	
	

	@Transactional
	public List<Stock> getAllFacebook() {
	Date date = null, date2 = null;
	date = Date.valueOf("2019-09-01");
	date2 = Date.valueOf("2019-09-30");
	return repository.findByCodeAndDateBetween("FB", date, date2);
	}



	@Transactional
	public List<Stock> getAllGoogle() {
	return repository.findByCloseGreaterThan(1250);
	}



	@Transactional
	public List<Stock> highest5Transactions() {
	return repository.findFirst3ByOrderByVolumeDesc();
	}



	@Transactional
	public List<Stock> lowest3TransactionsNFLX() {
	return repository.findFirst3ByCodeOrderByCloseAsc("NFLX");
	}
	
//	public static void testGetEmployee() {
//		LOGGER.info("Start");
//		Employee employee = employeeService.get(1);
//		LOGGER.debug("Employee:{}", employee);
//		LOGGER.debug("Department:{}", employee.getDepartment());
//		LOGGER.debug("Skills:{}", employee.getSkillList());
//		LOGGER.info("End");
//	}
	
//	public static void testAddEmployee() {
//		LOGGER.info("Start");
//		Employee employee = new Employee();
//		employee.setName("Raka");
//		employee.setSalary(50000);
//		employee.setPermanent(true);
//		employee.setDate_of_birth(Date.valueOf("1995-02-21"));
//		Department department = departmentService.get(1);
//		employee.setDepartment(department);
//		employeeService.save(employee);
//		LOGGER.debug("Employee:{}", employee);
//		LOGGER.info("End");
//	}
	
//	public static void testUpdateEmployee() {
//		LOGGER.info("Start");
//		Employee employee = employeeService.get(2);
//		Department department = departmentService.get(1);
//		employee.setDepartment(department);
//		employeeService.save(employee);
//		LOGGER.debug("Employee:{}", employee);
//		LOGGER.info("End");
//	}
//	public static void testGetDepartment() {
//		LOGGER.info("Start");
//		Department department = departmentService.get(1);
//		LOGGER.debug("Department:{}", department);
//		Set<Employee> employees = department.getEmployeeList();
//		LOGGER.debug("Employee List:{}", employees);
//		LOGGER.info("End");
//	}
//
	public static void testAddSkillToEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(3);
		Skill skill = skillService.get(2);
		employee.getSkillList().add(skill);
		employeeService.save(employee);
		LOGGER.info("End");
	}
	public static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.getAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}
	public static void testGetAverageSalary() {
		LOGGER.info("Average:{}", employeeService.getAverageSalary(1));
	}
	public static void testGetAllEmployeesNative() {
		LOGGER.info("Employee:{}", employeeService.getAllEmployeesNative());
	}
//	public static void testGetAverageSalary() {
//		LOGGER.info("Average:{}", employeeService.getAverageSalary());
//	}


//	private static void testGetAllCountries() {
//
//		LOGGER.info("Start");
//
//		List<Country> countries =countryService.getAllCountries();
//
//		LOGGER.debug("countries={}", countries);
//
//		LOGGER.info("End");

//		}
//	private static void getAllCountriesTest() throws CountryNotFoundException {
//
//		LOGGER.info("Start");
//		Country country = countryService.findCountryByCode("IN");
//		LOGGER.debug("Country:{}", country);
//		LOGGER.info("End");
//	}
//	private static void testAddCountry() throws CountryNotFoundException {
//		LOGGER.info("Start");
//		Country country = new Country();
//		country.setCode("US");
//		country.setName("United States Of America");
//		countryService.addCountry(country);
//		country = countryService.findCountryByCode("IN");
//		LOGGER.debug("Country:{}", country);
//		LOGGER.info("End");	
//	}
//	private static void testUpdateCountry() throws CountryNotFoundException {
//		LOGGER.info("Start");
//		countryService.updateCountry("IN", "INDIA");
//		Country country = countryService.findCountryByCode("IN");
//		LOGGER.debug("Country:{}", country);
//		LOGGER.info("End");		
//	}
//
//	private static void testFindByNameContaining() {
//
//		List<Country> cList = countryService.findByNameContaining("ou");
//		System.out.println("----------------------COUTRIES CONTAINING ou IN NAME---------------------------");
//		for (Country c : cList) {
//			System.out.println(c.getCode() + " " + c.getName());
//		}
//		System.out.println("------------------------------------------------------------------");
//	}
//	private static void testFindByNameContainingOrderByAsc() {
//
//		List<Country> cList = countryService.findByNameContainingOrderByAsc("ou");
//		System.out.println("------------------------COUTRIES CONTAINING ou IN NAME IN ASCENDING ORDER-------------------");
//		for (Country c : cList) {
//			System.out.println(c.getCode() + " " + c.getName());
//		}
//		System.out.println("-------------------------------------------------------------------");
//	}

//	private static void testfindByNameStartingWith() {
//		List<Country> list = countryService.findByNameStartingWith("z");
//		System.out.println("-------------------------------COUNTRIES STARTING WITH z----------------------------------- ");
//		for (Country c : list) {
//			System.out.println(c.getCode() + " " + c.getName());
//		}
//		System.out.println("--------------------------------------------------------------------");
//	}
//	private static void testDeleteCountry() throws CountryNotFoundException{
//		LOGGER.info("Start");
//		countryService.deleteCountry("US");
//		Country country = countryService.findCountryByCode("US");
//		LOGGER.debug("Country:{}", country);
//		LOGGER.info("End");		
//	}
//

	public static void main(String[] args) throws CountryNotFoundException {
		
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		OrmLearnApplication application = context.getBean(OrmLearnApplication.class);
		countryService = context.getBean(CountryService.class);

		List<Stock> list = application.getAllFacebook();
		for (Stock stock : list) {
		System.out.println("------get all facebook details------");
		System.out.println(stock.toString());

		}
		list = application.getAllGoogle();
		for (Stock stock : list) {
		System.out.println("------get all google details------");
		System.out.println(stock.toString());

		}
		list = application.highest5Transactions();
		for (Stock stock : list) {
		System.out.println("------get highest 5 transaction details------");
		System.out.println(stock.toString());
		}



		list = application.lowest3TransactionsNFLX();
		for (Stock stock : list) {
		System.out.println("------get lowest 3 transaction details------");
		System.out.println(stock.toString());
		}
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);

//		testGetAllCountries();
		
//		getAllCountriesTest();
//		testAddCountry();
//		testUpdateCountry();
//		testDeleteCountry();
//		testFindByNameContaining();
//		testFindByNameContainingOrderByAsc();
//		testfindByNameStartingWith();
		
		//testGetEmployee();
		//testAddEmployee();
		//testUpdateEmployee();
		//testGetDepartment() ;
		testAddSkillToEmployee();
		testGetAllPermanentEmployees();
		testGetAverageSalary();
		testGetAllEmployeesNative();

		LOGGER.info("Inside main");
	}

}
