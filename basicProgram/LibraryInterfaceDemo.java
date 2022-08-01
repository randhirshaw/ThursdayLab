package ClassWork;
import java.util.Scanner;
interface LibraryUser{
	void registerAccount();
	void requestBook();
}
class KidUsers implements LibraryUser{
	int age; String bookType;
	Scanner s = new Scanner(System.in);
	@Override
	public void registerAccount() {
		System.out.println("Enter the Age: ");
		age=s.nextInt();
		if(age<12) {
			System.out.println("You have successfully registered under a Kids Account!");
			requestBook();
		}
		else
			System.out.println("Sorry, Age must be less than 12 to register as a kid!");
	}
	@Override
	public void requestBook() {
		System.out.println("Enter the Book Type: ");
		bookType=s.next();
		if(bookType.equalsIgnoreCase("Kids")) 
			System.out.println("Book Issued successfully! \r\n"
					+ "please return the book within 10 days.");
		else
			System.out.println("Oops, you are allowed to take only kids books!");
	}
}
class AdultUser implements LibraryUser{
	int age; String bookType;
	Scanner sc = new Scanner(System.in);
	@Override
	public void registerAccount() {
		System.out.println("Enter the Age: ");
		age=sc.nextInt();
		if(age>=12) {
			System.out.println("You have successfully registered under an Adult Account!");
			requestBook();
		}
		else
			System.out.println("Sorry, Age must be greater than 12 to register as a adult!");
	}
	@Override
	public void requestBook() {
		System.out.println("Enter the Book Type: ");
		bookType=sc.next();
		if(bookType.equalsIgnoreCase("Fiction")) 
			System.out.println("Book Issued successfully! \r\n"
					+ "please return the book within 7 days.");
		else
			System.out.println("Oops, you are allowed to take only adult Fiction books!");
	}
}
public class LibraryInterfaceDemo {
	public static void main(String[] args) {
		KidUsers kids = new KidUsers();
		kids.registerAccount();
		//kids.requestBook();
		System.out.println("\n*********************************************************************************\n ");
		AdultUser adult = new AdultUser();
		adult.registerAccount();
		//adult.requestBook();
	}
}
