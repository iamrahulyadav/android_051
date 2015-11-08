package com.wimc.dialogbox;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	TextView textData,textDate;
	Button btMovie, btDOB;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textData = (TextView) findViewById(R.id.textView1);
		textDate = (TextView) findViewById(R.id.textView2);
		btMovie = (Button) findViewById(R.id.button1);
		btDOB = (Button) findViewById(R.id.button2);

		btMovie.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final Dialog d = new Dialog(MainActivity.this);
				d.setTitle("Movie Name");
				d.setContentView(R.layout.dialog_view);

				// get data from box

				final EditText editMovie = (EditText) d
						.findViewById(R.id.editText1);
				Button btOk = (Button) d.findViewById(R.id.button1);
				d.show();
				
				btOk.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

						String str = editMovie.getText().toString();
						textData.setText("Watch:" + str);

						d.dismiss();

					}
				});

			}
		});
		
		
		btDOB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final Dialog d = new Dialog(MainActivity.this);
				d.setTitle("Select DOB");
				d.setContentView(R.layout.date_view);
				d.show();
				final DatePicker picker=(DatePicker)d.findViewById(R.id.datePicker1);
				Button btDone=(Button)d.findViewById(R.id.button1);

				btDone.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
					int day=picker.getDayOfMonth();
					int month=picker.getMonth();
					int year=picker.getYear();
					textDate.setText(day+":"+month+":"+year);
					d.dismiss();
						
						
					}
				});
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
