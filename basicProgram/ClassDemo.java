package oopsProgram;
//public class CountObjects {
//	static int count =0;
//	public CountObjects() {
//		count++;
//		System.out.println(count);
//	}
//	public static void main(String[] args) {
//		CountObjects c1= new CountObjects();
//		CountObjects c2= new CountObjects();
//		CountObjects c3= new CountObjects();
//		CountObjects c4= new CountObjects();
//	}
//}
class Stud {
	int id;//instance variable
	String name,address;
	long phno;
	static String institute = "Anudip Foundation";
	public Stud(int i,String n,String add, long ph) {  
		this.id=i;
		this.name=n;
		this.address=add;
		this.phno=ph;
	}
	public static void ChangeInstituteName() {
		institute ="Anudip Foundation for Welfare";
	}
	public void getData() {
		System.out.println("id : "+ id + "name : "+ name+
			"   address:  "+ address+"ph no: "+phno+institute);
	}
}
public class ClassDemo {
	   public static void main ( String [] args) {
		   Stud rahul=new Stud(101,"Rahul","kokata",8658745869L);
		   Stud randhir = new Stud(102,"Raja","kokata",8638745869L);
		   randhir.getData();
		   rahul.ChangeInstituteName();
		   rahul.getData(); 
	   }
}