package com.hibernate.Lab;

public class CourseNotFoundException extends Exception{
	public String getMessage(int id)
	{
		return "Course Not found with id "+id;
	}
}
