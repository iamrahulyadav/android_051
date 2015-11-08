package com.example.assign_gps;

import android.app.Dialog;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements LocationListener {
	Button btEnable, btNot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

		boolean b = locationManager
				.isProviderEnabled(LocationManager.GPS_PROVIDER);

		if (b) {

			Toast.makeText(this, "GpS Enabled", 5).show();

		}

		else {

			final Dialog d = new Dialog(MainActivity.this);
			d.setTitle("Enable GPS");
			d.setContentView(R.layout.dialog);
			btEnable = (Button) d.findViewById(R.id.button2);
			btNot = (Button) d.findViewById(R.id.button1);

			btEnable.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
				
				
					startActivity(	new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
					
					d.dismiss();

				}
			});

			btNot.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {

					d.dismiss();

				}
			});
			d.show();
		}
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

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}
}
