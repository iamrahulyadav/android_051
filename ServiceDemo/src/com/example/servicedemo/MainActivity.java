package com.example.servicedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	EditText editName;
	Button btStart, btStop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editName = (EditText) findViewById(R.id.editText1);
		btStart = (Button) findViewById(R.id.button1);
		btStop = (Button) findViewById(R.id.button2);
		btStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = editName.getText().toString();
				Intent intent = new Intent(MainActivity.this,
						MyFileService.class);
				intent.putExtra("name", str);
				startService(intent);
			}
		});
		btStop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = editName.getText().toString();
				Intent intent = new Intent(MainActivity.this,
						MyFileService.class);
				intent.putExtra("name", str);
				stopService(intent);
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
