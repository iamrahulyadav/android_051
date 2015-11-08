package com.example.sqlitedatabase1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper{

	public DataHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
	db.execSQL("create table student(rollno integer primary key, name text, marks real, course text)");
	//insert some data
	db.execSQL("insert into student values(1001,'Bhaskar',30,'wimc')");
	db.execSQL("insert into student values(1002,'Akhil',21,'wimc')");
	db.execSQL("insert into student values(1003,'Yogi',33,'wimc')");
	db.execSQL("insert into student values(1004,'Alturist',45,'wimc')");
	db.execSQL("insert into student(name,marks,course) values('Thakur',55,'DAC')");
	Log.e("database:","on create");
	
	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
