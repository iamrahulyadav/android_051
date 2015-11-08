package com.example.sqlitedatabase1.controller;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlitedatabase1.model.DataHelper;
import com.example.sqlitedatabase1.model.Student;

public class StudentController {

	DataHelper helper;

	public StudentController(Context context) {
		helper = new DataHelper(context, DataHelper.DBNAME, null,
				DataHelper.VERSION);
	}

	public void insertStudent(Student stu) {
		// create insert query

		String query = "insert into student(name,marks,course)values('"
				+ stu.getName() + "'," + stu.getMarks() + ",'"
				+ stu.getCourse() + "')";

		// open database

		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL(query);
		db.close();

	}

	public void deleteStudent(Student stu) {

		SQLiteDatabase db = helper.getWritableDatabase();

		db.delete("student", "rollno=" + stu.getRollno(), null);

		db.close();

	}

	public void updateStudent(Student stu) {
		SQLiteDatabase db = helper.getWritableDatabase();

		// db.execSQL(query);

		ContentValues values = new ContentValues();
		values.put("name", stu.getName());
		values.put("marks",stu.getMarks());

		values.put("course", stu.getCourse());

		db.update("student", values, "rollno=" + stu.getRollno(), null);

		db.close();

	}

	public ArrayList<Student> getAllStudent() {

		// open Database

		SQLiteDatabase db = helper.getWritableDatabase();
		// fetch data from student table
		String query = "select * from student";
		Cursor cursor = db.rawQuery(query, null);
		// cursor.getCount();

		ArrayList<Student> listStudent = new ArrayList<Student>();

		listStudent.clear();
		while (cursor.moveToNext()) {
			int r = cursor.getInt(0); // first col is int
			String n = cursor.getString(1);
			float m = cursor.getFloat(2);
			String c = cursor.getString(3);
			// String data = r + ":" + n + ":" + m + ":" + c;
			Student stu = new Student(r, n, m, c);
			listStudent.add(stu);
		}
		cursor.close();
		db.close();

		return listStudent;

	}
}
