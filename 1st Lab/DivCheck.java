import java.util.Scanner;
public class DivCheck {
	public static void main(String[] args) {
		int num1;
		Scanner obj = new Scanner(System.in);
System.out.println("Enter the number: ");
num1 = obj.nextInt();
if((num1%5==0) && (num1%11==0))
	System.out.println("The Number is Divisible By 5 and 11");
else
	System.out.println("The Number is not Divisible By 5 and 11");
	}
} 
