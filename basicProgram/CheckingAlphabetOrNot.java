package basicProgram;

public class CheckingAlphabetOrNot {

	public static void main(String[] args) {
		char c = 'd';
		if((c>='A' && c<='Z') || (c>'a' && c<='z'))
		System.out.println(c + " is an Alphabet");
		else 
			System.out.println(c + " is not an Alphabet");
	}

}
