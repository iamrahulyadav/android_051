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
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathappclient.LoginActivity.LoginTask;

public class LoginByPost extends Activity {

	/**
	 * @param args
	 */
	EditText editEmail, editPass;
	Button btLogin;
	TextView textResult;
	CheckBox ckRemember;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.login);

		editEmail = (EditText) findViewById(R.id.editText1);
		editPass = (EditText) findViewById(R.id.editText2);
		btLogin = (Button) findViewById(R.id.button1);

		btLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String email = editEmail.getText().toString();
				String pass = editPass.getText().toString();
				SharedPreferences sp = getSharedPreferences("myappdata",
						MODE_PRIVATE);
				SharedPreferences.Editor edit = sp.edit();

				edit.putString("email",email);

				edit.commit();
				String url = "http://192.168.76.26:9090/ServiceApp/LoginService";

				LoginTask task = new LoginTask();

				task.execute(url);

			}
		});

	}

	class LoginTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub

			HttpClient client = new DefaultHttpClient();

			// store parameters as Name Value Pairs

			NameValuePair np1 = new BasicNameValuePair("email", params[1]);
			NameValuePair np2 = new BasicNameValuePair("password", params[2]);

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

				String msg = mainJSONObj.getString("result");

				if (msg.equalsIgnoreCase("success")) {
					
					

					Intent intent = new Intent(LoginByPost.this,
							AddByPostActivity.class);

					startActivityForResult(intent, 101);

					Toast.makeText(LoginByPost.this, "Login succesful",
							Toast.LENGTH_LONG).show();

				}

				else {
					Toast.makeText(LoginByPost.this, msg, Toast.LENGTH_LONG)
							.show();
				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}


	

