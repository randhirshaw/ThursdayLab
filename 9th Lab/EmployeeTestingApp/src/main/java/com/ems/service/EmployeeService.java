package com.ems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ems.entity.Address;
import com.ems.entity.Employee;
import com.ems.exception.GlobalException;

import lombok.Builder;

public class EmployeeService {
	private List<Employee> emp=new ArrayList<Employee>();
	
	//Method to add employee details in array list
	public void addEmployee(long empId, String name, double sal,
			String city, String country) {
		Address add= new Address(city, country);
		emp.add(new Employee(empId, name, sal, add));
	}
	
	//Method to display all employee
	public List<Employee> displayAllEmp() {
		//for(Employee e: emp) {
//			return "Employee(empId="+ e.getEmpId()+
//			", empName="+ e.getEmpName()+
//			", empSal="+ e.getEmpSal()+
//			", a=Address(city="+e.getA().getCity()+", country="
//			+e.getA().getCountry()+"))";
//		}
		
		return emp;
		
	}
	
	//Method to display employee details by id
	public Employee displayEmpById(long id) throws GlobalException {
		for(int i=0;i<emp.size();i++) {
			if(emp.get(i).getEmpId()==id) {
				System.out.println("Employee Id: "+ emp.get(i).getEmpId());
				System.out.println("Employee Name: "+ emp.get(i).getEmpName());
				System.out.println("Employee salary: "+ emp.get(i).getEmpSal());
				System.out.println("Employee Address: "+emp.get(i).getA().getCity()+" "
				+emp.get(i).getA().getCountry());
				return emp.get(i);
			}
			else 
				throw new GlobalException("Employee id not found");
		}
		return null;
	}
	
	//Method to Delete all employee details
	public String deleteAllDetails() {
		emp.clear();
		return "All Employees Deleted Successfully";
	}
	
	//Method to delete employee by id
	public void deleteEmpById(int id) throws GlobalException {
		boolean bool =false;
		for(int i=0;i<emp.size();i++) {
			if(id==emp.get(i).getEmpId()) {//Checking enter id is exist or not
				emp.remove(i); //Deleting data
				System.out.println("Employee with ID "+id+" Is deleted succesfully");
				bool=true;
			}
		}	
		if(bool==false) throw new GlobalException("Employee id not found");
	}
	
	public Employee findId(int id) {
		Employee e=null;
		for(int i=0;i<emp.size();i++) 
			if(emp.get(i).getEmpId()==id)
				e=emp.get(i);;
		return e;
	}
	
	//Method to update the employee data
	public Employee updateEmpById (int index, Employee e) throws GlobalException {
		return emp.set(index, e);
		
	}
	
	//To calculate the yearly salary of employee by Id
	public double calculateYrSalary(long id) {
		double yrSal=0;
		for(int i=0;i<emp.size();i++) {
			if(emp.get(i).getEmpId()==id)
				yrSal= emp.get(i).getEmpSal()*12;
		}
		return yrSal;
	}
	
	//Calculate the appraisal amount of employee 
	public double calAppraisalById(long id) {
		double apprais=0;
		for(int i=0;i<emp.size();i++) {
			if(emp.get(i).getEmpId()==id) {
				if(emp.get(i).getEmpSal()<10000)
					apprais=1000;
				else
					apprais=2000;
			}
		}
		return apprais;
	}
	
	public int lengthOfList() {
		return emp.size();
	}
	
	//for builder ex add employee
	public Employee addEmployee(Employee e) {
		emp.add(e);
		return e;
	}
	
}