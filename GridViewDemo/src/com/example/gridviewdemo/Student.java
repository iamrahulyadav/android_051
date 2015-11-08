package com.example.gridviewdemo;

public class Student {
String name;
int imageId;
public Student(String name, int imageId) {
	super();
	this.name = name;
	this.imageId = imageId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getImageId() {
	return imageId;
}
public void setImageId(int imageId) {
	this.imageId = imageId;
}
@Override
public String toString() {
	return name;
}

}
