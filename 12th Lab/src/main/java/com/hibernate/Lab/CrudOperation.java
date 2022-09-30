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
	static Transaction t;
	static Instructor instructor=new Instructor();
	static Course course=new Course();
	
	public static void addInstructor()
	{
		session.beginTransaction();
		System.out.println("Enter Instructor ID:");
		int id=sc.nextInt();
		sc.nextLine();
		instructor.setInstructorId(id);
		System.out.println("Enter Instructor Name:");
		String name=sc.nextLine();
		instructor.setInstructorName(name);
		
		System.out.println("Instructor has been added successfully");
		session.save(instructor);
		session.getTransaction().commit();
	}
	public static void addCourse()
	{
		session.beginTransaction();
		System.out.println("Enter Course Name: ");
		String cname=sc.nextLine();
		course.setCourseName(cname);
		
		System.out.println("Course has been added successfully");
		session.save(course);
		session.getTransaction().commit();
	}
	
	public static void assignCourseToInstructor(int inId,int cId) throws CourseNotFoundException
	{
		Instructor instruct=session.get(Instructor.class,inId);

		Course course=session.get(Course.class,cId);
		List<Course> clist=new ArrayList<>();
		clist.add(course);

		instruct.setCourses(clist);
		course.setInstructor(instruct);
		session.beginTransaction();
		session.saveOrUpdate(instruct);
		session.getTransaction().commit();
	}

	public static void getDetails() 
	{
		session.beginTransaction();
		Query query=session.createQuery("from Course");
		List<Course> list=query.getResultList();
		System.out.println("Number of Courses--> "+list.size());
        for (Course c : list) {
            System.out.println("Course ID:- "+c.getCourseId()+", Course Name:- "+c.getCourseName()+
            		", Course Instructor:- "+c.getInstructor().getInstructorName());
        }
        session.getTransaction().commit();
	}
	public static void updateInstructorById(int id) throws InstructorNotFoundException
	{
		session.beginTransaction();
		System.out.println("Enter New Instructor Name:");
		String name=sc.nextLine();
		Query query = session.createQuery("update Instructor set instructorName=:in where instructorId=:id");
        query.setParameter("in", name);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("No of rows updated: "+result);
	}
	public static void updateCourseById(int id) throws CourseNotFoundException
	{
		session.beginTransaction();
		System.out.println("Enter New Course Name:");
		String name=sc.nextLine();
		Query query = session.createQuery("update Course set courseName=:cn where courseId=:id");
        query.setParameter("cn", name);
        query.setParameter("id", id);
        int result = query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("No of rows updated: "+result);
	}
	public static void deleteInstructorById(int id) throws InstructorNotFoundException
	{
		session.beginTransaction();
		instructor= session.get(Instructor.class, id);
	
		session.delete(instructor);
		System.out.println("Record deleted!");
//		Query query = session.createQuery("delete from Instructor where instructorId=:id");
//        query.setParameter("id", id);
//        int result = query.executeUpdate();
		session.getTransaction().commit();
        //System.out.println("No of rows deleted: "+result);
	}
	public static void deleteCourseById(int id) throws CourseNotFoundException
	{
		session.beginTransaction();
		Query query = session.createQuery("delete from Course where courseId=:id");
        query.setParameter("id", id);
        int result = query.executeUpdate();
        session.getTransaction().commit();
        System.out.println("No of rows deleted: "+result);
	}
}
