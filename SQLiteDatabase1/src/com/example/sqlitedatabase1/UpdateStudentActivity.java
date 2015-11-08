package com.example.sqlitedatabase1;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateStudentActivity extends Activity {

	EditText editName, editMarks, editCourse;
	Button btUpdate, btDelete;
	TextView textRoll;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.updatestudent);
		editName = (EditText) findViewById(R.id.editText1);
		editMarks = (EditText) findViewById(R.id.editText2);
		editCourse = (EditText) findViewById(R.id.editText3);

		btUpdate = (Button) findViewById(R.id.button1);
		btDelete = (Button) findViewById(R.id.button2);
		textRoll = (TextView) findViewById(R.id.textView1);

		Intent intent = getIntent();

		Student stu = (Student) intent.getSerializableExtra("student");

		editName.setText(stu.getName());
		editMarks.setText(stu.getMarks() + " ");
		editCourse.setText(stu.getCourse());

		textRoll.setText(stu.getRollno() + " ");

		final String rollno = textRoll.getText().toString();

		btUpdate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String name = editName.getText().toString();
				String marks = editMarks.getText().toString();
				String course = editCourse.getText().toString();

				// create insert query

				// String query =
				// "update student set name='?',marks=?,course='?'"+"where rollno=?";

				// open database

				DataHelper helper = new DataHelper(UpdateStudentActivity.this,
						"wimcdb", null, 1);

				SQLiteDatabase db = helper.getWritableDatabase();

				// db.execSQL(query);

				ContentValues values = new ContentValues();
				values.put("name", name);
				values.put("marks", Float.parseFloat(marks));

				values.put("course", course);

				int result = db.update("student", values, "rollno=" + rollno,
						null);

				if (result > 0) {
					Toast.makeText(UpdateStudentActivity.this,
							"updated sucessfully", Toast.LENGTH_SHORT).show();
					finish();
				}
				db.close();

			}
		});

		btDelete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				DataHelper helper = new DataHelper(UpdateStudentActivity.this,
						"wimcdb", null, 1);

				SQLiteDatabase db = helper.getWritableDatabase();

				int result = db.delete("student", "rollno=" + rollno, null);

				if (result > 0) {
					Toast.makeText(UpdateStudentActivity.this,
							"deleted sucessfully", Toast.LENGTH_SHORT).show();
					finish();
				}
				db.close();

			}
		});

	}
}
