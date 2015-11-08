package com.example.sqlitedatabase1;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewStudentActivity extends Activity {

	EditText editName, editMarks, editCourse;
	Button btInsert;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newstudent);
		editName = (EditText) findViewById(R.id.editText1);
		editMarks = (EditText) findViewById(R.id.editText2);
		editCourse = (EditText) findViewById(R.id.editText3);
		btInsert = (Button) findViewById(R.id.button1);

		btInsert.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String name = editName.getText().toString();
				String marks = editMarks.getText().toString();
				String course = editCourse.getText().toString();

				// create insert query

				String query = "insert into student(name,marks,course)values('"
						+ name + "'," + marks + ",'" + course + "')";

				// open database

				DataHelper helper = new DataHelper(NewStudentActivity.this,
						"wimcdb", null, 1);

				SQLiteDatabase db = helper.getWritableDatabase();
				db.execSQL(query);
				db.close();

				
				Toast.makeText(NewStudentActivity.this,
						"insertion is sucessfull", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
	}

}
