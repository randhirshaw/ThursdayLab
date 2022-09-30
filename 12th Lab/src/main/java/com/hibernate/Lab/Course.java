package com.hibernate.Lab;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int courseId;
	
	@Column(name="course_Name")
	String courseName;
	
	@ManyToOne   //many books can be written by one author
	@JoinColumn(name="instructor_id")   
	private Instructor instructor;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Course(int courseId, String courseName, Instructor instructor) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.instructor = instructor;
	}

	public Course() {
		super();
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + "]";
	}
}