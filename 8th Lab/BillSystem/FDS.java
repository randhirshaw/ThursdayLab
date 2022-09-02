

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class FDS {
	static int choice; static char ch;
	static ArrayList<FoodMenu> list =new ArrayList<FoodMenu>();
	static ArrayList<BL> blist =new ArrayList<BL>();
	static Scanner sc = new Scanner(System.in);
	//create Food method
	public static void foodMenu() {	
		FoodMenu f1=new FoodMenu(0,"Biryani Combo",200.0);
		FoodMenu f2=new FoodMenu(1,"Chinese Combo",250.0);
		FoodMenu f3=new FoodMenu(2,"Badaa Platter",200.0);
		FoodMenu f4=new FoodMenu(3,"Dhosa Platter",350.00);
		
		list.add(f1); list.add(f2); list.add(f3); list.add(f4);
		
		System.out.println("~Welcome to B.Tech Pakode Wala Restaurant~");
		Iterator itr= list.iterator();  
		while(itr.hasNext()){  
			FoodMenu fd=(FoodMenu)itr.next();  
			System.out.println(fd.getFoodId()+") "+fd.getFoodName()+"\t\t"+fd.getFoodPrice());  
		}  
		
		System.out.println("***************************************************");
	}
	
	static void order(String fname, double amt) {
		System.out.println("Enter quantity for "+fname+":");
		int qty = sc.nextInt();
		blist.add(new BL(fname,qty,qty*amt));
	}
	public static void orderFood() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter Food id: ");
			int id = sc.nextInt();
			FoodMenu fd = (FoodMenu) list.get(id);
			FDS.order(fd.getFoodName(), fd.getFoodPrice());

			System.out.println("Wanna have more food? Yes/No: ");
			ch=sc.next().charAt(0);
			if(ch==('Y')||ch==('y'))
				System.out.println("Choice: "+ch);
			else {
				System.out.println("Choice: "+ch);
				System.out.println("***************************************************");
				foodBill();
				break;
			}
		}
		while(true);
	}
	public static void foodBill() {
		double sum = 0;
		for(BL i: blist) {
			System.out.println(i.fName+"\t\t"+i.quan+"\t\t"+i.price);
			sum = sum + i.price;
		}

		double gst=32.5;
		System.out.println("Total: \t"+sum+"rs"+"\nGST: \t"+gst);
		System.out.println("Net Ammount: \t"+ (sum+gst)+"rs");
		System.out.println("***************************************************");
		System.out.println("\nThank You For Visitinng Us!");
		System.out.println("***************************************************");
		
	}
}
