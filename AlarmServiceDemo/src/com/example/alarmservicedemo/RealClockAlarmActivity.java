package com.example.alarmservicedemo;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RealClockAlarmActivity extends ActionBarActivity {

	Button btSet, btCancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btCancel = (Button) findViewById(R.id.button2);
		btSet = (Button) findViewById(R.id.button1);

		btSet.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(RealClockAlarmActivity.this, MyService.class);

				PendingIntent pi = PendingIntent.getService(RealClockAlarmActivity.this,
						1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

				// find time to execute   :  31-12-2014  
				
				
				Calendar cal=Calendar.getInstance();
				cal.set(2014,10,12,16,15,0);
				long timeToExecute=cal.getTimeInMillis();
				
				
				// pass timeToExecute and PI to alarmService

				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);

				// alarmmanager.set(type, triggerAtMillis, operation)

				alarmmanager.setRepeating(AlarmManager.RTC_WAKEUP,
						timeToExecute, 3000, pi);

			}
		});

		btCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(RealClockAlarmActivity.this, MyService.class);

				PendingIntent pi = PendingIntent.getService(RealClockAlarmActivity.this,
						1, intent, PendingIntent.FLAG_CANCEL_CURRENT);

				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);

				alarmmanager.cancel(pi);

			}
		});

	}

	
}
