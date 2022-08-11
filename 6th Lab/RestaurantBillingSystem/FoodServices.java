package RestaurantBillingSystem;
import java.util.Scanner;
public class FoodServices {
	static int choice; static char ch;
	static double dummy[]=new double[4];
	static int q[]=new int[4];
	//create Food method
	public static void foodMenu() {	
		int id[]= {1,2,3,4};
		String fname[]= {"Biryani Combo","Chinese Combo","Bada Platter Combo","Dhosa Platter"};
		double fprice[]={200.0,250.0,200.0,350.00};
		System.out.println("~Welcome to B.Tech Pakode Wala Restaurant~");
		for(int i=0;i<4;i++) {
			Food food=new Food(id[i], fname[i], fprice[i]);
			System.out.println(id[i]+". "+fname[i]+"\t"+fprice[i]);
		}
		System.out.println("***************************************************");
	}
	public static void orderFood() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Wanna Exit? Press 5");
		do {
			System.out.println("Enter Food id: ");
			choice=sc.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Biryani Combo Enter Quantity: ");
					q[0]=sc.nextInt();
					break;	
				case 2:
					System.out.println("Chinese Combo Enter Quatity: ");
					q[1]=sc.nextInt();
					break;
				case 3:
					System.out.println("Bada Platter Enter Quatity: ");
					q[2]=sc.nextInt();
					break;
				case 4:
					System.out.println("Dhosa Platter Enter Quatity: ");
					q[3]=sc.nextInt();
					break;
			}
			System.out.println("Want to have more food? Yes/No: ");
			ch=sc.next().charAt(0);
			if(ch==('Y')||ch==('y'))
				System.out.println("ch: "+ch);
			else {
				System.out.println("ch: "+ch);
				dummy[0]=((double) q[0])*200.0;
				dummy[1]=((double) q[1])*250.0;
				dummy[2]=((double) q[2])*200.0;
				dummy[3]=((double) q[3])*350.0;
				System.out.println("***************************************************");
				break;
			}
		}
		while(choice!=5);
		foodBill();
	}
	public static void foodBill() {
		double sum = 0;
		for(int i=0;i<4;i++) {
			if(q[i]!=0 && i==0) {
				System.out.println("Biryani Combo \t"+q[i]+"\t"+dummy[i]);
				sum+=(dummy[i]);
			}
			if(q[i]!=0&& i==1) {
				System.out.println("Chenese Combo \t"+q[i]+"\t"+dummy[i]);
				sum+=(dummy[i]);
			}
			if(q[i]!=0&& i==2) {
				System.out.println("Bada Combo \t"+q[i]+"\t"+dummy[i]);
				sum+=(dummy[i]);
			}
			if(q[i]!=0&& i==3) {
				System.out.println("Dhosa Combo \t"+q[i]+"\t"+dummy[i]);
				sum+=(dummy[i]);
			}
		}
		double gst=32.5;
		System.out.println("Total: "+sum+"rs"+"\nGST: "+gst);
		System.out.println("Net Ammount: "+ (sum+gst));
	}
}