package com.example.reminder;

import java.util.ArrayList;

import com.example.reminder.controller.ReminderController;
import com.example.reminder.model.Reminder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HistoryActivity extends Activity {

	ListView listHistory;
	Reminder rem = new Reminder();
	ArrayList<Reminder> listRem = new ArrayList<Reminder>();
	ArrayAdapter<Reminder> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.history);

		listHistory = (ListView) findViewById(R.id.listView1);
		adapter = new ArrayAdapter<Reminder>(this,
				android.R.layout.simple_list_item_1, listRem);

		listHistory.setAdapter(adapter);

		

	}
	
	@Override
	protected void onStart() {

		super.onStart();
		ReminderController remCont = new ReminderController(
				HistoryActivity.this);
		listRem=remCont.showReminder();
		adapter=new ArrayAdapter<Reminder>(this,android.R.layout.simple_list_item_1,listRem);
		listHistory.setAdapter(adapter);
	}


}
