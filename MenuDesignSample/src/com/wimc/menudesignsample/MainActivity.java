package com.wimc.menudesignsample;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	EditText editData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("Wimc");

		editData = (EditText) findViewById(R.id.editText1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.homemenu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.menuCube:

			String str = editData.getText().toString();
			int a = Integer.parseInt(str);
			int c = a * a * a;
			Toast.makeText(this, "cube:" + c, 5).show();
			break;

		case R.id.menuNext:

			Intent intent = new Intent(MainActivity.this, NextActivity.class);
			startActivity(intent);

			break;

		case R.id.menuExit:
			finish();
			break;

		default:
			break;

		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
