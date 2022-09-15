package com.ems.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ems.entity.Address;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;

@TestMethodOrder(value= OrderAnnotation.class)
class EmployeeServiceTest {
	static EmployeeService employeeService;
	static List<Employee> emplist;
	
	@BeforeAll
	static void init() {
		emplist=new ArrayList<Employee>();
	}

	@BeforeEach
	void setUp() throws Exception {
		employeeService= new EmployeeService();
	}

	@AfterEach
	void tearDown() throws Exception {
		employeeService =null;
		System.out.println("Object is garbage collected");
	}

	@Test
	@DisplayName("Adding Employee")
	@Order(1)
	void testAddEmployee() {
		//way 1
//		employeeService.addEmployee(101, "nill", 20000, "Kolkata", "India");
//		employeeService.addEmployee(102, "Salman", 22000, "Indore", "India");
//		assertEquals(2, employeeService.lengthOfList());
		
		//way2 using builder 
		Address add= Address.builder().city("Kolkata").country("India").build();
		Employee emp= Employee.builder().empId(101).empName("Randhir").empSal(20000.0).a(add).build();
		employeeService.addEmployee(emp);
		//assertEquals(2,employeeService.lengthOfList());
		int length=employeeService.lengthOfList();
		assertThat(length>0).isTrue();
	}

	@Test
	@DisplayName("Display Employee By Id")
	@Order(2)
	void testDisplayEmpById() throws GlobalException{
		
		//way 1
		employeeService.addEmployee(108, "nilanjan", 20000, "Kolkata", "India");    
		Employee e=employeeService.displayEmpById(108);
		assertEquals("nilanjan", e.getEmpName());
		assertThat(e.getEmpSal()).isEqualTo(20000);
		
		//way 2
//		Address add = Address.builder().city("Kolkata").country("India").build();
//		Employee emp = Employee.builder().empId(102).empName("Nilanjan").empSal(25000.00).a(add).build();
//		employeeService.addEmployee(emp);
//		Employee e2 =employeeService.displayEmpById(102);
//		//assertEquals("Nilanjan",e.getEmpName());
//		assertThat(e2.getEmpSal()).isEqualTo(25000.00);
	}
	
	@Test
	@DisplayName("delete all employee details")
	@Order(6)
	void testDeleteAllDetails() {
		assertEquals("All Employees Deleted Successfully",employeeService.deleteAllDetails());
	}
	
	@Test
	@DisplayName("Appraisal Test")
	@Order(3)
	void testCalAppraisalById() throws GlobalException {
		employeeService.addEmployee(101, "Saquib", 25000, "Kalyani", "India");
		double appraisal = employeeService.calAppraisalById(101);
		//assertEquals(2000, appraisal);
		assertThat(appraisal).isEqualTo(2000);
	}

	@Test
	@DisplayName("Updating employee")
	@Order(4)
	void testUpdateEmpById() throws GlobalException {
		employeeService.addEmployee(101, "nilanjan", 25000, "Darjeeling", "India");
		Employee emp = employeeService.findId(101);
		emp.setEmpName("Shawin");
		
		Employee update = employeeService.updateEmpById(0, emp);
		assertThat(update.getEmpName()).isEqualTo("Shawin");
	}

	@Test
	@Order(5)
	@DisplayName("Testing calculate yearly salary")
	void testCalculateYrSalary() {
		Address add = Address.builder().city("Kolkata").country("India").build();
		Employee emp = Employee.builder().empId(102).empName("Nilanjan").
				empSal(25000.00).a(add).build();
		employeeService.addEmployee(emp);
		double sal = employeeService.calculateYrSalary(102);
		//assertEquals(300000.00, sal);
		assertThat(sal).isEqualTo(25000*12);
	}

	@Test
	@DisplayName("Display All Employee")
	@Order(value=7)
	void testDisplayAllEmp() {
		Address add = Address.builder().city("Kolkata").country("India").build();
		Employee emp = Employee.builder().empId(102).empName("Nilanjan").
				empSal(25000.00).a(add).build();
		employeeService.addEmployee(emp);
		emplist = employeeService.displayAllEmp();
		//assertThat(emplist.size()).isGreaterThan(0);
		assertThat(emplist).isNotNull();
	}
	
	@Test
	@DisplayName("Delete By Employee Id")
	@Order(8)
	void testDeleteEmpById() throws GlobalException {
		employeeService.addEmployee(105, "Salman", 22000, "Indore", "India");
		employeeService.addEmployee(106, "nil", 2000, "jeeling", "India");
		employeeService.addEmployee(107, "nilanjan", 25000, "Darjeeling", "India");
		
		employeeService.deleteEmpById(107);
		//int length=employeeService.lengthOfList();
		//assertThat(length<1).isTrue();
		assertEquals(2,employeeService.lengthOfList());
	}
	
	@Test
	@DisplayName("Negative Test Case")
	@Order(9)
	void testNegattiveDelById() throws GlobalException {
		employeeService.addEmployee(105, "Salman", 22000, "Indore", "India");
		employeeService.addEmployee(106, "nil", 2000, "jeeling", "India");
		employeeService.addEmployee(107, "nilanjan", 25000, "Darjeeling", "India");
		
		employeeService.deleteEmpById(107);
		//int length=employeeService.lengthOfList();
		//assertThat(length<1).isTrue();
		assertEquals(3,employeeService.lengthOfList());
	}
}
