package com.example.sharedpreferencesdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	EditText editPass;
	Button btGo;
	String oldPass;
	RelativeLayout mainLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editPass = (EditText) findViewById(R.id.editText1);
		btGo = (Button) findViewById(R.id.button1);
		mainLayout = (RelativeLayout) findViewById(R.id.mainView);
		// open shared preferences

	}

	@Override
	protected void onResume() {

		// TODO Auto-generated method stub
		super.onResume();
		


		final SharedPreferences sp = getSharedPreferences("myappdata",
				MODE_PRIVATE);
		oldPass = sp.getString("password", null);
		if (oldPass == null) // if no pass created earlier
			editPass.setHint("create new password");

		btGo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (oldPass == null) // create new password
				{
					String pass = editPass.getText().toString();
					// store in shared preferences
					SharedPreferences.Editor edit = sp.edit();

					edit.putString("password", pass);

					edit.commit();

					editPass.setHint("Enter Password");

					Toast.makeText(MainActivity.this, "Password created..", 5)
							.show();

					oldPass = pass;

				} else {
					String pass = editPass.getText().toString();
					if (oldPass.equals(pass)) {
						Intent intent = new Intent(MainActivity.this,
								SettingActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(MainActivity.this, "Wrong Password..", 5)
								.show();

					}
				}

			}
		});

		int theme = sp.getInt("theme", 3);
		switch (theme) {
		case 1:
			mainLayout.setBackgroundColor(Color.RED);
			break;
		case 2:
			mainLayout.setBackgroundColor(Color.GREEN);
			break;
		case 3:
			mainLayout.setBackgroundColor(Color.CYAN);
			break;
		default:
			break;
		}
	}
}
