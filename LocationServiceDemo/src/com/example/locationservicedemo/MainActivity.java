package com.example.locationservicedemo;

import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements LocationListener {

	TextView textLati, textLong;
	Button btShowonMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		textLati = (TextView) findViewById(R.id.textView1);
		textLong = (TextView) findViewById(R.id.textView2);
		
		btShowonMap = (Button) findViewById(R.id.button1);
		// instantiate location manager
		
		LocationManager locManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		

		// register location manager
		locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000,
				100, this);

		btShowonMap.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String url = "https://www.google.co.in/maps/@"
						+ textLati.getText().toString() + ","
						+ textLong.getText().toString() + ",15z?hl=en";

				Intent i = new Intent(Intent.ACTION_VIEW);

				i.setData(Uri.parse(url));
				startActivity(i);

			}
		});

	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		double lati = location.getLatitude();
		double longi = location.getLongitude();

		textLati.setText(lati + "");
		textLong.setText(longi + "");

		Geocoder geocoder;
		List<Address> addresses;
		geocoder = new Geocoder(this, Locale.getDefault());
		try {
			addresses = geocoder.getFromLocation(lati, longi, 1);

			if (addresses != null || addresses.size() > 0) {
				String address = addresses.get(0).getAddressLine(0);
				String city = addresses.get(0).getAddressLine(1);
				String country = addresses.get(0).getAddressLine(2);
				Toast.makeText(this, address + ":" + city + ":" + country, 5)
						.show();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		
		 double distance,main_Latitude,main_Longitude,sub_Latitude,sub_Longitude;
		 
		 main_Latitude=18.5604748;
		 main_Longitude=73.8081602;
		 
		 sub_Latitude=location.getLatitude();
				 sub_Longitude=location.getLongitude();

         Location locationA = new Location("");

         locationA.setLatitude(main_Latitude);

         locationA.setLongitude(main_Longitude);

         Location locationB = new Location("");
         

         locationB.setLatitude(sub_Latitude);

         locationB.setLongitude(sub_Longitude);

         distance = locationA.distanceTo(locationB)/1000;
      
         Toast.makeText(getApplicationContext(), ""+distance, Toast.LENGTH_LONG).show();
		
		
		
		
		
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
