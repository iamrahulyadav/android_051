package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ManagementGuru extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.managemenrguru);
		textview = (TextView) findViewById(R.id.textViewmanagementguru);
		String str = "";
		textview.setText(str);
         
	}
}
