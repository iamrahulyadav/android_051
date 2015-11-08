package model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelperQuiz extends SQLiteOpenHelper {
	public static final String DBNAME = "quiz";
	public static final int VERSION  = 1;


	@SuppressLint("NewApi") public DataHelperQuiz(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("create table quiz(no integer primary key , qus text , ans integer , set integer , module integer  ) ");
	//	db.execSQL(" insert into student values (1000, 'how are you',8.8,'fuck off')");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
