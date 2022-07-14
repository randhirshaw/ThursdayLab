import java.util.Scanner;
public class GrossSalary {
	private static Scanner sc;
	public static void main(String[] args) {
		int b,hrA,dA,g;
		System.out.println("Enter the Basic Salary: ");
		sc = new Scanner(System.in);
		b = sc.nextInt();
		if(b>=1500) {
			hrA=20*b/100;
			dA=90*b/100;
		}
		else {
			hrA=500;
			dA= 70*b/100;
		}
		g = b+dA+hrA;
		System.out.println("The Gross salary of the employee is: " +g);
	}
}