package com.example.sqlitedatabase1;

import java.util.ArrayList;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	ListView listViewStudent;
	ArrayList<Student> listStudent = new ArrayList<Student>();
	ArrayAdapter<Student> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listViewStudent = (ListView) findViewById(R.id.listView1);
		adapter = new ArrayAdapter<Student>(this,
				android.R.layout.simple_list_item_1, listStudent);

		listViewStudent.setAdapter(adapter);

		listViewStudent.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Intent intent = new Intent(MainActivity.this,
						UpdateStudentActivity.class);
				
				Student stu=adapter.getItem(arg2);
				intent.putExtra("student", stu);
				startActivity(intent);

			}


		});
	}

	@Override
	protected void onStart() {

		super.onStart();

		// open Database
		DataHelper helper = new DataHelper(this, "wimcdb", null, 1);
		SQLiteDatabase db = helper.getWritableDatabase();
		// fetch data from student table
		String query = "select * from student";
		Cursor cursor = db.rawQuery(query, null);
		// cursor.getCount();
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
		adapter.notifyDataSetChanged();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.menuAdd) {
			Intent intent = new Intent(MainActivity.this,
					NewStudentActivity.class);
			startActivity(intent);
		}
		if (id == R.id.menuExit) {
			finish();
		}

		return super.onOptionsItemSelected(item);
	}
}
