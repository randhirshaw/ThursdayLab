package oopsProgram;
import java.util.Scanner;
class Employee{
	int empId, empJoin,CurrYr;
	int basicSalary;
	String empName,Designation;
	public void setData(int CY,int id,String name,String role,int JY,int bs) {
		CurrYr = CY;
		empId = id;
		basicSalary = bs;
		empJoin = JY;
		empName = name;
		Designation = role;
	}
	public int getAppraisal() {
		if(CurrYr-empJoin>1) {
			int Salary= basicSalary+(basicSalary*(10/100));
			return Salary;
		}
		else 
			return basicSalary; 
	}
	public int TravelAllowance() {
		int TA=0;
		if(Designation.equals("manager")||Designation.equals("Manager"))
			TA = 3000;
		else TA = 1000;
		return TA;
	}
	public void Display() {
		float bs = getAppraisal();
		int Travel = TravelAllowance();
		System.out.println("Employee Id: "+ empId+
				"\nEmployee Name: "+ empName+
				"\nEmployee Designation: "+Designation+
				"\nEmployee Basic Salary: "+ bs+
				"\nEmployee Joining Year: "+ empJoin+
				"\nEmployee Travel Allowence: "+Travel);
	}
}
public class EmployeeData {
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.println("Enter Current Year: ");
		int CY = sc.nextInt();
		System.out.println("Enter Employee Id: ");
		int id = sc.nextInt();
		System.out.println("Enter Employee Name: ");
		String name = sc.next();
		System.out.println("Enter Employee Designation Role: ");
		String role = sc.next();
		System.out.println("Enter Employee Joining Year: ");
		int JY = sc.nextInt();
		System.out.println("Enter Employee Basic Salary: ");
		int bs = sc.nextInt();
		Employee emp= new Employee();
		emp.setData(CY, id, name, role, JY, bs);
		emp.Display();
	}
}
