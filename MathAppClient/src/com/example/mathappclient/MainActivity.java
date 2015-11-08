package com.example.mathappclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	EditText editNum1, editNum2;
	Button btSubmit;
	TextView textResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editNum1 = (EditText) findViewById(R.id.editText1);
		editNum2 = (EditText) findViewById(R.id.editText2);
		btSubmit = (Button) findViewById(R.id.button1);

		textResult = (TextView) findViewById(R.id.textView3);
		SharedPreferences sp = getSharedPreferences("myappdata",
				MODE_PRIVATE);
		String email = sp.getString("email", null);
		textResult.setText(email);
		btSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String num1 = editNum1.getText().toString();
				String num2 = editNum2.getText().toString();

				String url = "http://192.168.76.26:9090/ServiceApp/"
						+ "AddService?n1=" + num1 + "&n2=" + num2;

				AddTask task = new AddTask();

				task.execute(url);

			}
		});
	}

	class AddTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			HttpGet hget = new HttpGet(params[0]);
			HttpClient client = new DefaultHttpClient();

			String result = "";

			try {
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
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			// convert data into JSON object

			try {
				JSONObject mainJSONObj = new JSONObject(result);
				String msg = mainJSONObj.getString("message");

				if (msg.equalsIgnoreCase("Success")) {

					int r = mainJSONObj.getInt("result");

					textResult.setText("sum" + r);
					
					Toast.makeText(MainActivity.this, r + "", Toast.LENGTH_LONG)
							.show();
				}

				else {
					Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG)
							.show();
				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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
		if (id == R.id.menulogout) {

			finish();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
