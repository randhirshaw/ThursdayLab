import java.util.Scanner;
public class CheckVowel {
	public static void main(String[] args) {
		char Key;
		System.out.println("Enter the Alphabet: ");
		Scanner obj = new Scanner(System.in);
		Key = obj.next().charAt(0);
		if(Key=='a'||Key=='e'||Key=='i'||Key=='o'||Key=='u'||Key=='A'||Key=='E'||Key=='O'||Key=='I'||Key=='U')
			System.out.println(Key+ " is a Vowel");
		else
			System.out.println(Key+ " is a Consonant");
	}
}
