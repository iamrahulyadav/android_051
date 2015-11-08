package com.akhil.gcmclientapp;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;

public class MainActivity extends ActionBarActivity {

	TextView textData;
	private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

	public static String sender_id = "264738128998";// Project Number

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textData = (TextView) findViewById(R.id.textView1);

		// register device
		SharedPreferences sp = getSharedPreferences("gcmdata", MODE_PRIVATE);
		String deviceId = sp.getString("device_Id", "");
		if (deviceId.equals("")&& checkPlayServices()) {
			RegistrationTask task = new RegistrationTask();
			task.execute();

		}

		else {
			textData.setText(deviceId);
		}

	}// EOF ocCrate
	
	private boolean checkPlayServices() {
	    int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
	    if (resultCode != ConnectionResult.SUCCESS) {
	        if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
	            GooglePlayServicesUtil.getErrorDialog(resultCode, this,
	                    PLAY_SERVICES_RESOLUTION_REQUEST).show();
	        } else {
	            Log.i("demo", "This device is not supported.");
	            finish();
	        }
	        return false;
	    }
	    return true;
	}

	class SendIdToServerTask extends AsyncTask<String, Void, String> {

		ProgressDialog pd = null;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub

			super.onPreExecute();
			pd = new ProgressDialog(MainActivity.this);
			pd.setTitle("sending.. red id to server");
			pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pd.show();

		}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub

			String result = "";

			try {
				HttpClient client = new DefaultHttpClient();

				HttpGet hget = new HttpGet(params[0]);

				HttpResponse response = client.execute(hget);

				InputStream is = response.getEntity().getContent();

				InputStreamReader reader = new InputStreamReader(is);

				BufferedReader br = new BufferedReader(reader);

				while (true) {
					String s = br.readLine();

					if (s == null)
						break;

					result = result + s;

				}
				br.close();

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return result;
		} // eof of donInbackground

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			Toast.makeText(MainActivity.this, result, 5).show();

			pd.cancel();

		}
	}

	// task for generating device id
	// this task if device is not registered
	class RegistrationTask extends
			AsyncTask<String /* input to doInBack */, Void/*
														 * return type of do in
														 * background method
														 */, String> {

		ProgressDialog pd = null;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();

			pd = new ProgressDialog(MainActivity.this);
			pd.setTitle("fetching id");
			pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			pd.show();

		}

		@Override
		protected String doInBackground(String... params) {
			// send request to GCM server
			GoogleCloudMessaging gcm = GoogleCloudMessaging
					.getInstance(getApplicationContext());

			String regId = "";
			try {
				regId = gcm.register(sender_id);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return regId;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			// save regId in shared prefrence and also send to server
			SharedPreferences sp = getSharedPreferences("gcmdata", MODE_PRIVATE);
			SharedPreferences.Editor edit = sp.edit();
			edit.putString("device_Id", result);
			edit.commit();

			textData.setText(result);
			
			Log.e("",result);
			
			pd.cancel();

			// send device_id to server

			// get mobile nmber

			TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

			String number = "deepak";

			String url = "http://192.168.43.28:8080/WimcAppServer/RegisterService"
					+ "?username=" + number + "&device_id=" + result;

			SendIdToServerTask task = new SendIdToServerTask();
			task.execute(url);

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
}
