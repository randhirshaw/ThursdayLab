import java.util.Scanner;
public class BankClass {
	private static Scanner sc;
	public static void main(String[] args) {
		int AccB,WDA;
		sc =new Scanner(System.in);
		System.out.println("Enter the Account Ballance: ");
		AccB= sc.nextInt();
		System.out.println("Enter the Withdraw Amount: ");
		WDA = sc.nextInt();
		if(AccB>WDA) {
			AccB-=WDA;
			System.out.println("Withdraw Successful! /n Your Current Ballance is :"+ AccB);
		}
		else System.out.println("You dont have Sufficient Ballance");
		AccB +=5000;
		System.out.println("Account Ballance: "+ AccB);
	}
}