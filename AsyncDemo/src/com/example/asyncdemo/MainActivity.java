package com.example.asyncdemo;

import android.database.CursorJoiner.Result;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	Button btPower;
	EditText editA, editB;
	TextView textResult;
	ProgressBar progBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btPower = (Button) findViewById(R.id.button1);
		editA = (EditText) findViewById(R.id.editText1);
		editB = (EditText) findViewById(R.id.editText2);

		textResult = (TextView) findViewById(R.id.textView1);

		btPower.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String str1 = editA.getText().toString();
				String str2 = editB.getText().toString();
				int a = Integer.parseInt(str1);
				int b = Integer.parseInt(str2);

				// start async

				PowerTask task = new PowerTask();

				task.execute(a, b);

			}
		});
	}

	class PowerTask extends AsyncTask<Integer, Integer, String> {
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub

			textResult.setText("started....");
			Toast.makeText(MainActivity.this, "---started---",
					Toast.LENGTH_LONG).show();

		}

		@Override
		protected String doInBackground(Integer... params) {

			int m = params[0];
			int n = params[1];
			int p = 1;
			for (int i = 1; i <= n; i++) {

				p = p * m;
				publishProgress(p);    // replaces handler
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String s = "power" + p;

			return s;
		}

		@Override
		protected void onPostExecute(String result) {

			super.onPostExecute(result);
			textResult.setText(result);
			Toast.makeText(MainActivity.this, "---stoppedddddddd---",
					Toast.LENGTH_LONG).show();
		}

		//  receives  intermediate data
		
		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
			int i=values[0];
			textResult.setText("..."+i);
		}
	}


}
