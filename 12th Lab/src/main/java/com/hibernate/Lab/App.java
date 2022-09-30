package com.hibernate.Lab;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	int choice;
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("Welcome to LMS");
		System.out.println("Press 1. To Create Instructor\n"
				+ "Press 2. To Get Course with Instructor Details\n"
				+ "Press 3. To Update Instructor by Id\n"
				+ "Press 4. To Update Course by Id\n"
				+ "press 5. To Delete Instructor by Id\n"
				+ "press 6. to Delete Course by Id\n"
				+ "press 7. To Quit");
		System.out.println("Enter your choice");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
			CrudOperation.createInstructor();
			System.out.println("=====================================");
			break;
			
		case 2: 
			CrudOperation.getDetails();
			System.out.println("=====================================");
			break;
			
		case 3:
			System.out.println("Enter Instructor ID: ");
			int id=sc.nextInt();
			sc.nextLine();
			try {
				CrudOperation.updateInstructorById(id);
			} catch(InstructorNotFoundException nf) {
				System.out.println(nf.getMessage(id));
			}
			System.out.println("=====================================");
			break;
		case 4:
			System.out.println("Enter Course ID: ");
			int id1=sc.nextInt();
			sc.nextLine();
			try {
				CrudOperation.updateCourseById(id1);
			} catch (CourseNotFoundException sf) {
				System.out.println(sf.getMessage(id1));
			}
			System.out.println("=====================================");	
			break;
				
		case 5:
			System.out.println("Enter Instructor ID: ");
			int id2=sc.nextInt();
			sc.nextLine();
			try {
				CrudOperation.deleteInstructorById(id2);
			} 
			catch (InstructorNotFoundException sf) {
				System.out.println(sf.getMessage(id2));	
			}
			System.out.println("=====================================");
				break;
		case 6:
			System.out.println("Enter Course ID: ");
			int id3=sc.nextInt();
			sc.nextLine();
			try {
				CrudOperation.deleteCourseById(id3);
			} 
			catch (CourseNotFoundException nf) {
				System.out.println(nf.getMessage(id3));	
			}
			System.out.println("=====================================");
				break;
		case 7: break;
		}
		}while(choice!=7);
    }
}
