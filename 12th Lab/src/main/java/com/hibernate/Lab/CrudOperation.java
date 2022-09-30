package com.hibernate.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CrudOperation {
	static Scanner sc=new Scanner(System.in);
	static SessionFactory sf=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	static Session session=sf.openSession();
	static Transaction t=session.beginTransaction();
	static Instructor instructor=new Instructor();
	static Course course=new Course();
	
	public static void  createInstructor()
	{
		System.out.println("Enter Instructor ID:");
		int id=sc.nextInt();
		sc.nextLine();
		instructor.setInstructorId(id);
		System.out.println("Enter Instructor Name:");
		String name=sc.nextLine();
		instructor.setInstructorName(name);
		
		System.out.println("Instructor has been added successfully");
		System.out.println("Enter Course Name:");
		String cname=sc.nextLine();
		course.setCourseName(cname);
		course.setInstructor(instructor);
		
		List<Course> clist=new ArrayList<>();
		clist.add(course);
		instructor.setCourses(clist);
		
		System.out.println("Course has been added successfully");
		session.save(instructor);
		t.commit();
		session.close();
	}

	public static void getDetails() 
	{
		Query query=session.createQuery("from Course");
		List<Course> list=query.getResultList();
		System.out.println("Number of Courses--> "+list.size());
        for (Course c : list) {
            System.out.println(c.getCourseId()+"\t"+c.getCourseName()+
            		"\t"+c.getInstructor().getInstructorName());
        }
        session.close();
	}
	public static void updateInstructorById(int id) throws InstructorNotFoundException
	{
		System.out.println("Enter Instructor Name:");
		String name=sc.nextLine();
		Query query = session.createQuery("update Instructor set instructorName=:in where instructorId=:id");
        query.setParameter("in", name);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        t.commit();
        System.out.println("No of rows updated: "+result);
        session.close();
	}
	public static void updateCourseById(int id) throws CourseNotFoundException
	{
		System.out.println("Enter Course Name:");
		String name=sc.nextLine();
		Query query = session.createQuery("update Course set courseName=:cn where courseId=:id");
        query.setParameter("cn", name);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        t.commit();
        System.out.println("No of rows updated: "+result);
        session.close();
	}
	public static void deleteInstructorById(int id) throws InstructorNotFoundException
	{
		Query query = session.createQuery("delete from Instructor where instructorId=:id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        t.commit();
        System.out.println("No of rows deleted: "+result);
        session.close();
	}
	public static void deleteCourseById(int id) throws CourseNotFoundException
	{
		Query query = session.createQuery("delete from Course where courseId=:id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        t.commit();
        System.out.println("No of rows deleted: "+result);
        session.close();
	}
}
