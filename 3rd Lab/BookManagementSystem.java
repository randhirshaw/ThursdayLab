package oopsProgram;
import java.util.Scanner;
class Book{
	int bookId, bookPrice;
	String bookName,authorName;
	static String library = " Randhir's Library";
	public void createBook(int id,int rs,String bn,String An) {
		bookId=id; bookPrice=rs;
		bookName=bn; authorName=An;
	}
	public String borrowBook() {
		String bk= null;
		if(bookName.equals("Rich Dad Poor Dad")||bookName.equals("The Psychology of Money")||bookName.equals("History")||bookName.equals("Geography")||bookName.equals("Science")||bookName.equals("English"))
			bk = "Book Is Available in";
		else bk = "Book Is not Available in ";
		return bk;
	}
	public void displayBook() {
		String Available = borrowBook();
		System.out.println("Book Id: "+ bookId+
			"\nBook Name: "+ bookName+
			"\nBook Author Name: "+authorName+
			"\nBook Price: "+ bookPrice);
		System.out.println(Available+library);
	}
}
public class BookManagementSystem {
	//private static Scanner sc;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Book Id: ");
		int id = sc.nextInt();
		System.out.println("Enter Book Price: ");
		int rs = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Book Name: ");
		String bn = sc.nextLine();
		System.out.println("Enter Book Author Name: ");
		String An = sc.nextLine();
		Book myBook= new Book();
		myBook.createBook(id,rs,bn,An);
		myBook.displayBook();
	}
}
