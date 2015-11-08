package com.example.sqlitedatabase1;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitedatabase1.controller.StudentController;
import com.example.sqlitedatabase1.model.DataHelper;
import com.example.sqlitedatabase1.model.Student;

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
				Student stu=new Student();
				stu.setMarks(Float.parseFloat(marks));
				stu.setCourse(course);
				stu.setName(name);
				// pass this to controller
				StudentController stuCon=new StudentController(NewStudentActivity.this);
				stuCon.insertStudent(stu);
			
				
				Toast.makeText(NewStudentActivity.this,
						"insertion is sucessfull", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
	}

}
