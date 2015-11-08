package com.wimc.listviewdemo;

import java.util.ArrayList;

import android.R.string;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	ListView listViewCities;
	EditText editCity;
	Button btAdd;

	ArrayList<String> listCities = new ArrayList<String>();
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listViewCities = (ListView) findViewById(R.id.listView1);
		editCity = (EditText) findViewById(R.id.editText1);
		btAdd = (Button) findViewById(R.id.button1);

		listCities.add("pune");
		listCities.add("mumbai");
		listCities.add("chennai");
		

		// create adapter

		adapter = new ArrayAdapter<String>(MainActivity.this,
				R.layout.graphic, listCities);

		// attach adapter to list view

		listViewCities.setAdapter(adapter);

		listViewCities.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				String s = adapter.getItem(arg2);
				Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();

			}

		});

		btAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String s = editCity.getText().toString();
				
				listCities.add(s);
				adapter.notifyDataSetChanged();
				Toast.makeText(MainActivity.this, "city added sucessfully", Toast.LENGTH_SHORT).show();

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
