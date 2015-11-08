package com.example.assign_locationsave;

import java.io.FileWriter;
import java.io.IOException;



import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements LocationListener {

	TextView textLati, textLong;
	
	String filePath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.activity_main);
		Intent intent = new Intent(MainActivity.this, MyService.class);

		startService(intent);
		textLati = (TextView) findViewById(R.id.textView1);
		textLong = (TextView) findViewById(R.id.textView2);
		ApplicationInfo appInfo = getApplicationInfo(); 
		final String strDataDirPath = appInfo.dataDir;
		
		filePath = strDataDirPath + "/location.txt";

		LocationManager locationmanager = (LocationManager) getSystemService(LOCATION_SERVICE);

		locationmanager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				5000, 10, this);
	}

	@Override
	public void onLocationChanged(Location location) {
		double lati, longi;
		lati = location.getLatitude();
		longi = location.getLongitude();
		
		textLati.setText(lati + "");
		textLong.setText(longi + "");
		String url = "https://www.google.co.in/maps/@"
				+ textLati.getText().toString() + ","
				+ textLong.getText().toString() + ",15z?hl=en";
		
		Toast.makeText(MainActivity.this,"hiiiiii",Toast.LENGTH_LONG).show();

		try {
			FileWriter writer = new FileWriter(filePath, false);
			writer.write(url);
			writer.flush();
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
