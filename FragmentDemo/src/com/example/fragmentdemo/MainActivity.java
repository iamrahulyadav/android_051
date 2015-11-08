package com.example.fragmentdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements CityListner {

	TextView textCity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textCity=(TextView) findViewById(R.id.textView1);
	}

	@Override
	public void setCity(String city) {
		// TODO Auto-generated method stub

		textCity.setText(city);

	}
}
