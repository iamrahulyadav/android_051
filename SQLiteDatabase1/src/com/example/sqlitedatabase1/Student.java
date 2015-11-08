package com.example.sqlitedatabase1;

import java.io.Serializable;

public class Student implements Serializable{

	int rollno;
	String name;
	float marks;
	String course;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int rollno, String name, float marks, String course) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.marks = marks;
		this.course = course;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return rollno + ":" + name + ":" + marks + ":" + course;
	}

}
