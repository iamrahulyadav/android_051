package com.example.assignxmlparsing;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	ImageView imageView;
	Button btXML, btImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView = (ImageView) findViewById(R.id.imageView1);
		btImage = (Button) findViewById(R.id.button2);
		btXML = (Button) findViewById(R.id.button1);
		btXML.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String url = "http://www.w3schools.com/xml/simple.xml";

				DownloadXMLTask task = new DownloadXMLTask();
				task.execute(url);

			}
		});

		

	}

	

		
	class DownloadXMLTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub

			HttpGet hget = new HttpGet(params[0]);
			// http client initialization
			HttpClient client = new DefaultHttpClient();
			String data = "";
			// send get request to server
			try {
				HttpResponse response = client.execute(hget);
				// read data from response
				InputStream in = response.getEntity().getContent();

				InputStreamReader reader = new InputStreamReader(in);

				BufferedReader br = new BufferedReader(reader);

				while (true) {
					String s = br.readLine();
					if (s == null)
						break;
					data = data + s;
				}// eof while
				br.close();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return data;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			String filePath = getApplicationInfo().dataDir + "/breakfast.xml";

			Log.e("loc:", filePath);

			try {
				FileWriter writer = new FileWriter(filePath, false);
				writer.write(result);
				writer.flush();
				writer.close();

				Toast.makeText(MainActivity.this, "XML Downloaded", 3).show();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}


  