import java.util.Scanner;
/*
Ques: create abstract class vaccine.create 2 concrete method firstDose() and 2ndDose().
Scenario 1:user can take first dose if user is Indian and age is 18.after vaccination user has to pay 250rs. 
Scenario 2: user can take 2nd dose if already the first dose has completed.
Scenario 3: create abstract method boosterDose() in abstract class Vaccine.create one implementation class vaccinationSuccessful where implement boosterDose() method.
Create main class vaccination and invoke all methods accord
 */
abstract class vaccine {
	protected static Scanner sc;
	abstract public void boosterDose(char b);  
	public Object firstDose() {
		int age, pay;
		String bride;
		sc =new Scanner(System.in);
		System.out.println("Enter the Nationality: ");
		bride = sc.nextLine();
		System.out.println("Enter the Age: ");
		age = sc.nextInt();
		if(bride.equals("Indian") && age>=18) {
			pay=250;
			System.out.println("Get ready for first Dose! \nYou Can take the First Dose.");
			System.out.println("Your Processing Fee is: "+pay+"rs");
		}
		else {
			pay=0;
			System.out.println("You can't take the First Dose. \nYou are not Eligible for First Dose!");
			System.out.println("Your Processing Fee is: "+pay+"rs");
		}
		return pay;
	}
	public Object secondDose(char c,int pay2) { 
		sc =new Scanner(System.in);    
		System.out.println("Did you took the First Dose? \n:- ");    
		c = sc.next().charAt(0);       
		if(c=='Y'||c=='y') {    
			pay2=250;
			System.out.println("you Can take The Second Dose!");
			System.out.println("Your Processing Fee is: "+pay2+"rs");
		}
		else {
			System.out.println("You can't take the Second Dose \nFirst of all Take the First Dose ");
			Object fstDose = firstDose();
		}
		return pay2;
	}
}
class vaccinationSuccessful extends vaccine {
	@Override
	public void boosterDose(char b) {  
		sc =new Scanner(System.in);     
		System.out.println("Did you took the Booster Dose? \n:- ");    
		b = sc.next().charAt(0);        
		if(b=='Y'||b=='y') {
			System.out.println("you are Eligible for Booster! \nStay Immune and Stay Safe!");
		}
		else if(b=='N'||b=='n') {    
			System.out.println("You can't take the Booster Dose \nFirst of all Take the Second Dose ");
			Object scnDose=secondDose(b, 0); 
	    }
		else System.out.println("Since you did'nt Took the First Dose \nYou are not Eligible for For Booster");
	}
}
public class VaccinationSystem {
	public static void main(String[] args) {
		vaccine vc = new vaccinationSuccessful();
		//vc.firstDose();
		//vc.secondDose((char) 0, 0);
		vc.boosterDose((char) 0);
	}
}
