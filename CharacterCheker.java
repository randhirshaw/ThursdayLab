import java.util.Scanner;
public class CharacterCheker {
	public static void main(String[] args) {
		char Character;
		System.out.println("Input a Character: ");
		Scanner obj = new Scanner(System.in);
		Character = obj.next().charAt(0);
		if((Character>='A'&&Character<='Z')||(Character>='a'&&Character<='z'))
			System.out.println(Character+ " is a alphabet");
		else if(Character>='0'&&Character<='9')
			System.out.println(Character+ " is a Digit");
		else 
			System.out.println(Character+ " is a Special Character");
	}
}
