package com.hibernate.Lab;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Instructor {
	@Id
	private int instructorId;
	private String instructorName;
	
	@OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
	List<Course> courses;

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Instructor() {
		super();
	}

	public Instructor(int instructorId, String instructorName, List<Course> courses) {
		super();
		this.instructorId = instructorId;
		this.instructorName = instructorName;
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Instructor [instructorId=" + instructorId + ", instructorName=" + instructorName + "]";
	}
	
}