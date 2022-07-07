import java.util.Scanner;
public class CalculateBonus {
	public static void main(String[] args) {
		int SerYear,Bonus=0,CurrYear,JoinYear;
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the Joining Year: ");
		JoinYear = obj.nextInt();
		System.out.println("Enter the Current Year: ");
		CurrYear = obj.nextInt();
		SerYear = CurrYear - JoinYear;
		if(SerYear>3) {
			Bonus = 2500;
			System.out.println("Increment in Bonus: " +Bonus);
		}
		else
			System.out.println("You are not eligible for Increment and your Current Bonus is: " + Bonus);
	}
}
