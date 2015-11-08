package com.example.multiscreenapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HomeActivity extends Activity {

	EditText e1;
	EditText e2;
	Button next;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		e1 = (EditText) findViewById(R.id.editText1);
		e2 = (EditText) findViewById(R.id.editText2);
		next = (Button) findViewById(R.id.button1);

		next.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				String name = e1.getText().toString();
				if(name.equals(""))
				{
					e1.setError("Please enter name");
					return;
				}
				
				String age = e2.getText().toString();
				if(age.equals(""))
				{
					e2.setError("Please enter age");
					return;
				}
				int a = Integer.parseInt(age);
				
				//Bundle to store data
				Bundle bundle=new Bundle();
				bundle.putString("username", name);
				bundle.putInt("age", a);
				
				// create explicit Intent
				//Intent intent=new Intent(packageContext,cls);
				Intent intent=new Intent(HomeActivity.this,NextActivity.class);
				
				//attach data with Intent
				intent.putExtras(bundle);
				
				//send intent to OS
				startActivity(intent);
				

			}
		});

	}

}
