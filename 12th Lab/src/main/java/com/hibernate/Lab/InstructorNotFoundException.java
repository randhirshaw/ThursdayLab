package com.hibernate.Lab;

public class InstructorNotFoundException extends Exception{
	public String getMessage(int id)
	{
		return "Instructor Not found with id "+id;
	}
}
