/**
 * @author Randhir
 * Write a program to calculate marks and average of five subjects and calculate grade based on certain condition:
 * if avg >= 90 grade A+
 * avg>=80 grade A
 * avg>=60 grade B
 * avg>=40 grade C
 * avg<40 grade D
 */
package basicProgram;
import java.util.Scanner;
public class RelationalOperator {
	public static void main(String[] args) {
		int s1,s2,s3,s4,s5,total,avg;
		Scanner sc =new Scanner(System.in);
System.out.println("Enter 5 marks: ");
s1=sc.nextInt();
s2=sc.nextInt();
s3=sc.nextInt();
s4=sc.nextInt();
s5=sc.nextInt();

total=s1+s2+s3+s4+s5;
avg=total/5;
System.out.println("Total: " + total + " Average: " + avg);
System.out.println("Grade");
if(avg>=90)
	System.out.println("A+");

else if(avg>=80)
	System.out.println("A");

else if(avg>=60)
	System.out.println("B");

else if(avg>=40)
	System.out.println("C");

else
	System.out.println("D");

	}

}