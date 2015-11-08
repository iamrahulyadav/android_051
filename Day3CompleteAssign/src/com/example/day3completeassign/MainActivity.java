package com.example.day3completeassign;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ActionBarActivity {

	ListView listViewDetails;
	Button btAdd;

	ArrayList<String> listDetails = new ArrayList<String>();
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		listViewDetails = (ListView) findViewById(R.id.listView1);
		btAdd = (Button) findViewById(R.id.button1);

		listDetails.add("Bhaskar:22:pune");
		listDetails.add("Devayan:21:mumbai");

		// create adapter

		adapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_list_item_1, listDetails);

		// attach adapter to list view

		listViewDetails.setAdapter(adapter);

		listViewDetails.setOnItemClickListener(new OnItemClickListener() {

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

				Intent intent = new Intent(MainActivity.this,
						AddRecordActivity.class);
				// send intent to OS
				// startActivity(intent);
				startActivityForResult(intent, 101);
			}

		});
	}
		
		@Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			
			super.onActivityResult(requestCode, resultCode, data);
			
			if(requestCode==101 && resultCode==RESULT_OK)
			{
				String detail=data.getStringExtra("result");
				
				listDetails.add(detail);
				
				adapter.notifyDataSetChanged();
			}
			

	}

}
