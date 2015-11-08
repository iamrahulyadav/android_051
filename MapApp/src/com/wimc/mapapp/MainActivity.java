package com.wimc.mapapp;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends ActionBarActivity {

	GoogleMap gmap;

	TextView textLocation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textLocation = (TextView) findViewById(R.id.textView1);

		MapFragment mapfrag = null;
		FragmentManager fragmentManager = getFragmentManager();

		mapfrag = (MapFragment) fragmentManager
				.findFragmentById(R.id.fragment1);

		gmap = mapfrag.getMap();
		// d

		/*
		 * 18.560975, 73.805837 ccd
		 * 
		 * 18.538433, 73.835561 esquare hotel
		 */

		LatLng locCCD = new LatLng(18.560975, 73.805837);

		MarkerOptions option1 = new MarkerOptions();
		option1.position(locCCD);
		option1.snippet("Worst coffee shop[ in aundh");
		gmap.addMarker(option1);

		LatLng locEsquare = new LatLng(18.538433, 73.835561);

		MarkerOptions option2 = new MarkerOptions();
		option2.position(locEsquare);
		option2.snippet("Worst multiplex in pune");
		gmap.addMarker(option2);

		// get location on map touch
		gmap.setOnMapClickListener(new OnMapClickListener() {

			@Override
			public void onMapClick(LatLng arg0) {
				// TODO Auto-generated method stub
				final double lati = arg0.latitude;
				final double longi = arg0.longitude;
				textLocation.setText(arg0.latitude + ":" + arg0.longitude);
				final Dialog d = new Dialog(MainActivity.this);
				d.setTitle("Send Location");
				d.setContentView(R.layout.dialog_view);

				// get data from box

				final EditText editNum = (EditText) d
						.findViewById(R.id.editText1);
				Button btOk = (Button) d.findViewById(R.id.button1);
				d.show();

				btOk.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

						String str = editNum.getText().toString();
						SmsManager smsManager = SmsManager.getDefault();

						smsManager.sendTextMessage(str, null, "Location:"
								+ lati + "," + longi + ":Name:Raj", null, null);

						IntentFilter filter = new IntentFilter();
						filter.addAction("android.provider.Telephony.SMS_RECEIVED");
						registerReceiver(new SmsListener(), filter);

						d.dismiss();

					}
				});

			}
		});

		// draw lines between 2 points
		PolylineOptions lineOption = new PolylineOptions();
		lineOption.add(locCCD, locEsquare);
		lineOption.color(Color.BLUE);
		lineOption.width(5);
		gmap.addPolyline(lineOption);

		// enable current location
		gmap.setMyLocationEnabled(true);

	}

	public class SmsListener extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub

			if (intent.getAction().equals(
					"android.provider.Telephony.SMS_RECEIVED")) {
				Bundle bundle = intent.getExtras(); // ---get the SMS message
													// passed in---
				SmsMessage[] msgs = null;
				String msg_from;

				if (bundle != null) {
					// ---retrieve the SMS message received---
					try {
						Object[] pdus = (Object[]) bundle.get("pdus");
						msgs = new SmsMessage[pdus.length];
						String msgBody = null;
						for (int i = 0; i < msgs.length; i++) {
							msgs[i] = SmsMessage
									.createFromPdu((byte[]) pdus[i]);
							msg_from = msgs[i].getOriginatingAddress();

							msgBody = msgs[i].getMessageBody();
						}
						Log.e("msg", msgBody);
						String[] msg = msgBody.split(":");
						String loc = msg[0];
						Log.e("Loc", loc);
						String name = msg[3];
						Log.e("name", name);
						
						String[] location = loc.split(",");
						String lati = location[0];
						Log.e("Lati", lati);
						String longi = location[1];
						Log.e("Longi",longi);
						// marker(lati,longi);
						
						Toast.makeText(MainActivity.this,
								"ghgh" + lati + " " + longi, 5).show();
						LatLng locCCD = new LatLng(Double.parseDouble(lati),
								Double.parseDouble(longi));

						MapFragment mapfrag = null;
						FragmentManager fragmentManager = getFragmentManager();

						mapfrag = (MapFragment) fragmentManager
								.findFragmentById(R.id.fragment1);

						gmap = mapfrag.getMap();
						
						MarkerOptions option1 = new MarkerOptions();
						option1.position(locCCD);
						option1.snippet("Your Friend is here");
						gmap.addMarker(option1);

					} catch (Exception e) {
						// Log.d("Exception caught",e.getMessage());
					}
				}

			}
		}
	}

}
