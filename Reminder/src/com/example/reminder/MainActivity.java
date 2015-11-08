package com.example.reminder;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.reminder.controller.ReminderController;
import com.example.reminder.model.Reminder;

public class MainActivity extends ActionBarActivity {

	Button btAdd, btHistory, btSelectDate;
	EditText editTitle, editDate;
	Spinner spinType;
	String type[] = { "Birthday", "Meeting", "Anniversary" };
	ArrayAdapter<String> adapter;
	String remType;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editTitle = (EditText) findViewById(R.id.editText1);

		editDate = (EditText) findViewById(R.id.editText2);
		btSelectDate = (Button) findViewById(R.id.button1);
		btAdd = (Button) findViewById(R.id.button2);
		btHistory = (Button) findViewById(R.id.button3);
		spinType = (Spinner) findViewById(R.id.spinner1);
		adapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_spinner_item, type);

		spinType.setAdapter(adapter);

		btSelectDate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				final Dialog d = new Dialog(MainActivity.this);
				d.setTitle("Select Date");
				d.setContentView(R.layout.date_view);
				d.show();
				final DatePicker picker = (DatePicker) d
						.findViewById(R.id.datePicker1);
				Button btDone = (Button) d.findViewById(R.id.button1);

				btDone.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						int day = picker.getDayOfMonth();
						int month = picker.getMonth();
						int year = picker.getYear();
						editDate.setText(day + "/" + month + "/" + year);
						d.dismiss();

					}
				});

			}
		});

		spinType.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				remType = adapter.getItem(arg2);

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}

		});

		btAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String title = editTitle.getText().toString();
				String date = editDate.getText().toString();

				String type = remType;
				
			

				Reminder rem=new Reminder();
				
				
				rem.setRemTitle(title);
				rem.setRemDate(date);
				rem.setRemType(type);
				
				// pass this to controller
				ReminderController remCont = new ReminderController(
						MainActivity.this);
				
				remCont.insertReminder(rem);

				Toast.makeText(MainActivity.this,
						"insertion is sucessfull", Toast.LENGTH_SHORT).show();
				editDate.setText("");
				editTitle.setText("");
				
			}
		});
		
		
		btHistory.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent= new Intent(MainActivity.this,HistoryActivityDel.class);
				
				startActivity(intent);
				
			}
		});
		

	}
}
