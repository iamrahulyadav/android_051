package com.example.alarmservicedemo;

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

public class MainActivity extends ActionBarActivity {

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
				Intent intent = new Intent(MainActivity.this, MyService.class);

				PendingIntent pi = PendingIntent.getService(MainActivity.this,
						1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

				// find time to execute

				long bootTime = SystemClock.elapsedRealtime();
				long timeToExecute = bootTime + 5 * 1000;

				// pass timeToExecute and PI to alarmService

				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);

				// alarmmanager.set(type, triggerAtMillis, operation)

				alarmmanager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
						timeToExecute, 3000, pi);

			}
		});

		btCancel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(MainActivity.this, MyService.class);

				PendingIntent pi = PendingIntent.getService(MainActivity.this,
						1, intent, PendingIntent.FLAG_CANCEL_CURRENT);

				AlarmManager alarmmanager = (AlarmManager) getSystemService(ALARM_SERVICE);

				alarmmanager.cancel(pi);

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
