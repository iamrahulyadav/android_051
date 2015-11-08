package com.example.spinnerdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	Spinner spnStudent;
	Button btSelect;
	TextView textName;
	String arr[] = { "bhaskar", "thakur", "alturist", "bhokmejande",
			"president", "guruji" };

	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		spnStudent = (Spinner) findViewById(R.id.spinner1);
		btSelect = (Button) findViewById(R.id.button1);
		textName = (TextView) findViewById(R.id.textView2);

		// instantiate adapter

		adapter = new ArrayAdapter<String>(MainActivity.this,
				R.layout.item_view, arr);

		// attach adapterb with view

		spnStudent.setAdapter(adapter);

		btSelect.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String str = (String) spnStudent.getSelectedItem();
				textName.setText(str);
				/* int p=spnStudent.getSelectedItemPosition();
				 String str1=adapter.getItem(p);
*/
			}
		});

		
		// spinner item selection event
		
		spnStudent.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
			String s=adapter.getItem(arg2);
			textName.setText(s);
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		
		
		
		});
		
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
