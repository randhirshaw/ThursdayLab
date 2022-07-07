import java.util.Scanner;
public class UppercaseLowercase {
	public static void main(String[] args) {
		char Character;
		System.out.println("Input a Character: ");
		Scanner obj = new Scanner(System.in);
		Character = obj.next().charAt(0);
		if(Character>='A'&&Character<='Z')
			System.out.println(Character+ " is a Uppercase");
		else
			System.out.println(Character+ " is a Lowercase");
	}
}
