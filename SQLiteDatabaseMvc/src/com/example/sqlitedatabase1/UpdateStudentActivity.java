package com.example.sqlitedatabase1;

import com.example.sqlitedatabase1.controller.StudentController;
import com.example.sqlitedatabase1.model.DataHelper;
import com.example.sqlitedatabase1.model.Student;

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

		final Student stu = (Student) intent.getSerializableExtra("student");

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

				
				stu.setMarks(Float.parseFloat(marks));
				stu.setCourse(course);
				stu.setName(name);

				StudentController stuCon = new StudentController(
						UpdateStudentActivity.this);
				stuCon.updateStudent(stu);

				finish();
			}
		});

		btDelete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// Student stu=new Student();

				StudentController stuCon = new StudentController(
						UpdateStudentActivity.this);
				stuCon.deleteStudent(stu);
				finish();

			}
		});

	}
}
