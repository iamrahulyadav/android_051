package com.example.mathappclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
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

public class AddByPostActivity extends ActionBarActivity {

	EditText editNum1, editNum2;
	Button btSubmit;
	TextView textResult,textUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		editNum1 = (EditText) findViewById(R.id.editText1);
		editNum2 = (EditText) findViewById(R.id.editText2);
		btSubmit = (Button) findViewById(R.id.button1);
		textUser = (TextView) findViewById(R.id.textView4);
		textResult = (TextView) findViewById(R.id.textView3);
		SharedPreferences sp = getSharedPreferences("myappdata", MODE_PRIVATE);
		String email = sp.getString("email", null);
		textUser.setText(email);
		btSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String num1 = editNum1.getText().toString();
				String num2 = editNum2.getText().toString();

				String url = "http://192.168.76.26:9090/ServiceApp/AddService";

				AddTask task = new AddTask();

				task.execute(url, num1, num2);

			}
		});
	}

	class AddTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub

			HttpClient client = new DefaultHttpClient();

			// store parameters as Name Value Pairs

			NameValuePair np1 = new BasicNameValuePair("n1", params[1]);
			NameValuePair np2 = new BasicNameValuePair("n2", params[2]);

			// store all parameters in a list

			List<NameValuePair> listNP = new ArrayList<NameValuePair>();

			listNP.add(np1);
			listNP.add(np2);

			String result = "";
			// post rqst and attach list of parameters
			try {

				HttpPost hpost = new HttpPost(params[0]);

				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(listNP);

				hpost.setEntity(entity);

				

				HttpResponse response = client.execute(hpost);

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
			} catch (Exception e) {
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
					Toast.makeText(AddByPostActivity.this, r + "",
							Toast.LENGTH_LONG).show();
					textResult.setText("sum" + r);

					
				}

				else {
					Toast.makeText(AddByPostActivity.this, msg,
							Toast.LENGTH_LONG).show();
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
