package com.hibernate.Lab;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
    	int choice;
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("Welcome to LMS");
		System.out.println("=====================================");
		System.out.println("Press 1. To Create Instructor\n"
				+ "Press 2. To Create Course\n"
				+ "Press 3. Assign Course to Instructor\n"
				+ "Press 4. To Get Course with Instructor Details\n"
				+ "Press 5. To Update Instructor by Id\n"
				+ "Press 6. To Update Course by Id\n"
				+ "press 7. To Delete Instructor by Id\n"
				+ "press 8. to Delete Course by Id\n"
				+ "press 9. To Quit");
		System.out.println("=====================================");
		System.out.println("Enter your choice: ");
		choice=sc.nextInt();
		System.out.println("=====================================");
		switch(choice)
		{
		case 1:
			CrudOperation.addInstructor();
			System.out.println("=====================================");
			break;
			
		case 2:
			CrudOperation.addCourse();
			System.out.println("=====================================");
			break;
			
		case 3: 
			System.out.println("Enter Course ID to Assign: ");
			int cId=sc.nextInt();
			System.out.println("Enter Instructor ID Assign: ");
			int inId=sc.nextInt();
			try {
				CrudOperation.assignCourseToInstructor(inId, cId);
			} 
			catch (CourseNotFoundException nf) {
				System.out.println(nf.getMessage(cId));	
			}
			System.out.println("=====================================");
			break;
			
		case 4: 
			CrudOperation.getDetails();
			System.out.println("=====================================");
			break;
			
		case 5:
			System.out.println("Enter Instructor ID to Update: ");
			int id=sc.nextInt();
			try {
				CrudOperation.updateInstructorById(id);
			} catch(InstructorNotFoundException nf) {
				System.out.println(nf.getMessage(id));
			}
			System.out.println("=====================================");
			break;
		case 6:
			System.out.println("Enter Course ID to Update: ");
			int id1=sc.nextInt();
			try {
				CrudOperation.updateCourseById(id1);
			} catch (CourseNotFoundException sf) {
				System.out.println(sf.getMessage(id1));
			}
			System.out.println("=====================================");	
			break;
				
		case 7:
			System.out.println("Enter Instructor ID to Delete: ");
			int id2=sc.nextInt();
			try {
				CrudOperation.deleteInstructorById(id2);
			} 
			catch (InstructorNotFoundException sf) {
				System.out.println(sf.getMessage(id2));	
			}
			System.out.println("=====================================");
				break;
		case 8:
			System.out.println("Enter Course ID to Delete: ");
			int id3=sc.nextInt();
			try {
				CrudOperation.deleteCourseById(id3);
			} 
			catch (CourseNotFoundException nf) {
				System.out.println(nf.getMessage(id3));	
			}
			System.out.println("=====================================");
				break;
			
		case 9: 
			System.out.println("Thank You For Visiting!!");
			break;
		}
		} while(choice!=9);
    }
}
