package BillSystem;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FDS {
	static char ch;
	//Using Array List Interface of Collection Interface
	static ArrayList<FoodMenu> list =new ArrayList<>();
	static ArrayList<BL> blist =new ArrayList<BL>();
	static Scanner sc = new Scanner(System.in);
	//create Food method
	public static void foodMenu() {	
		//Adding FoodItems on FoodMenu List
		FoodMenu f0=new FoodMenu(0,"Mineral Water", 00.0);
		FoodMenu f1=new FoodMenu(1,"Biryani Combo",200.0);
		FoodMenu f2=new FoodMenu(2,"Chinese Combo",250.0);
		FoodMenu f3=new FoodMenu(3,"Badaa Platter",200.0);
		FoodMenu f4=new FoodMenu(4,"Dhosa Platter",350.0);
		//list.add(new FoodMenu(0,"Mineral Water", 00.0)); 
		list.add(f0); list.add(f1); list.add(f2); list.add(f3); list.add(f4);
		
		System.out.println("___________________________________________");
		System.out.println("~Welcome to B.Tech Pakode Wala Restaurant~");
		System.out.println("===========================================");
		System.out.println("_________");
		System.out.println("MEGA MENU");
		System.out.println("*********");
		System.out.println("Water is Free For Everyone.\nPress '0' to get the Water!");
		System.out.println("_________________________________");
		System.out.println("ITEMS\t\t\tPrice");
		System.out.println("=================================");
		
		Iterator itr= list.iterator();  
		while(itr.hasNext()){  
			FoodMenu fd=(FoodMenu)itr.next();  
			System.out.println(fd.getFoodId()+") "+fd.getFoodName()+"\t"+fd.getFoodPrice());  
		}  
		
		System.out.println("---------------------------------");	
	}
	
	static void order(String fname, double amt) {
		System.out.println("Enter Quantity of "+fname+": ");
		int q= sc.nextInt();
		blist.add(new BL(fname, q, q*amt));
	}
	public static void orderFood() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Please Enter Food id: ");
			int id = sc.nextInt();
			FoodMenu fd = (FoodMenu) list.get(id);
			FDS.order(fd.getFoodName(), fd.getFoodPrice());

			System.out.println("Wanna have more food? Yes/No: ");
			ch=sc.next().charAt(0);
			if(ch!='y' && ch!='Y') {
				System.out.println("_________________________________");
				foodBill(); 
				//System.exit(0); 
				break;
			}
		}
		while(true);
	}
	public static void foodBill() {
		double sum = 0;
		System.out.println("Items\t\tQ.\tPrice");
		System.out.println("---------------------------------");
		for(BL i: blist) {
			System.out.println(i.fName+"\t"+i.quan+"\t"+i.price);
			sum +=i.price;
		}

		double gst=sum*0.18;
		System.out.println("---------------------------------");
		System.out.println("BILLING AREA");
		System.out.println("---------------------------------");
		System.out.println("Total: \t"+sum+" rs"+"\nGST: \t"+gst);
		System.out.println("---------------------------------");
		System.out.println("Net Ammount: \t"+ (sum+gst)+" rs");
		System.out.println("---------------------------------");
		System.out.println("\n*****************************************************");
		System.out.println("\nThank You For Visiting B.Tech Pakode Wala Restaurant!");
		System.out.println("*****************************************************");
	}
}
