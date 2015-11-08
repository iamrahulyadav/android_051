package com.wimc.day3assign2;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {

	ListView listViewCities;
	Spinner spnState;
	String arr[] = { "Maharashtra", "UP", "MP", "Goa", "CG" };

	String city1[] = { "Mumbai", "Pune", "navi mumbai" };
	String city2[] = { "Lucknow", "Itawa", "Varanasi" };
	String city3[] = { "Indore", "BHind" };
	String city4[] = { "Panji", "Vasco De Gama" };
	String city5[] = { "Raipur", "Bhilai", "Bilaspur", "Raigarh" };

	ArrayAdapter<String> adapter;
	ArrayAdapter<String> adapter2;

	ArrayList<String> listCities = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		spnState = (Spinner) findViewById(R.id.spinner1);
		listViewCities = (ListView) findViewById(R.id.listView1);

		adapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_list_item_1, arr);

		spnState.setAdapter(adapter);

		spnState.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				String s = adapter.getItem(arg2);

				if (s.equalsIgnoreCase("Maharashtra")) {

					adapter2 = new ArrayAdapter<String>(MainActivity.this,
							android.R.layout.simple_list_item_1, city1);

					listViewCities.setAdapter(adapter2);
					adapter2.notifyDataSetChanged();
				}

				if (s.equalsIgnoreCase("UP")) {

					adapter2 = new ArrayAdapter<String>(MainActivity.this,
							android.R.layout.simple_list_item_1, city2);

					listViewCities.setAdapter(adapter2);

					adapter2.notifyDataSetChanged();
				}

				if (s.equalsIgnoreCase("goa")) {

					adapter2 = new ArrayAdapter<String>(MainActivity.this,
							android.R.layout.simple_list_item_1, city4);

					listViewCities.setAdapter(adapter2);

					adapter2.notifyDataSetChanged();
				}
				if (s.equalsIgnoreCase("MP")) {

					adapter2 = new ArrayAdapter<String>(MainActivity.this,
							android.R.layout.simple_list_item_1, city3);

					listViewCities.setAdapter(adapter2);

					adapter2.notifyDataSetChanged();
				}
				if (s.equalsIgnoreCase("CG")) {

					adapter2 = new ArrayAdapter<String>(MainActivity.this,
							android.R.layout.simple_list_item_1, city5);

					listViewCities.setAdapter(adapter2);

					adapter2.notifyDataSetChanged();
				}

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

	}
}
