package com.example.reminder.controller;

import java.util.ArrayList;
import java.util.ListResourceBundle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.reminder.MainActivity;
import com.example.reminder.model.DataHelper;
import com.example.reminder.model.Reminder;




public class ReminderController {

	
	DataHelper helper;

	public ReminderController(Context context) {
		helper = new DataHelper(context, DataHelper.DBNAME, null,
				DataHelper.VERSION);
	}
	
	
	public ArrayList<Reminder> showReminder()
	{
		 

			// open Database

			SQLiteDatabase db = helper.getWritableDatabase();
			// fetch data from student table
			String query = "select * from reminder";
			Cursor cursor = db.rawQuery(query, null);
			// cursor.getCount();

			ArrayList<Reminder> listReminder = new ArrayList<Reminder>();

			listReminder.clear();
			while (cursor.moveToNext()) {
				int id = cursor.getInt(0); // first col is int
				String ti = cursor.getString(1);
				
				String d = cursor.getString(2);
				String t = cursor.getString(3);
				
				
				Reminder rem = new Reminder(id, ti, d, t);
				listReminder.add(rem);
			}
			cursor.close();
			db.close();

			return listReminder;

		}
		
	
	public void insertReminder(Reminder rem) {
		// create insert query

		String query = "insert into reminder(title,date,remtype)values('"
				+ rem.getRemTitle() + "','" + rem.getRemDate() + "','"
				+ rem.getRemType() + "')";
		
	

		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL(query);
		db.close();

	}
	
	public void deleteRem(Reminder rem){

	SQLiteDatabase db = helper.getWritableDatabase();

	db.delete("reminder", "remid=" + rem.getRemId(), null);

	db.close();

}
	
	
	
}
