package com.example.countdown;

import android.support.v7.app.ActionBarActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class CountDown extends ActionBarActivity {

	Button btGo, btStop,btResume;
	EditText editNum;
	TextView textResult;
	ProgressBar progBar;

	boolean status;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_count_down);

		btGo = (Button) findViewById(R.id.button1);
		btStop = (Button) findViewById(R.id.button2);
		btResume = (Button) findViewById(R.id.button3);

		editNum = (EditText) findViewById(R.id.editText1);

		textResult = (TextView) findViewById(R.id.textView2);
		progBar = (ProgressBar) findViewById(R.id.progressBar1);

		btGo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				status = true;
				
				String str1 = editNum.getText().toString();

				int a = Integer.parseInt(str1);

				// start async

				CounterTask task = new CounterTask();

				task.execute(a);

			}
		});

		btStop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				status = false;

			}
		});
	}

	class CounterTask extends AsyncTask<Integer, Integer, String> {

		@Override
		protected void onPreExecute() {

			super.onPreExecute();
			status = true;
			textResult.setText("started....");
			Toast.makeText(CountDown.this, "---started---", Toast.LENGTH_LONG)
					.show();

		}

		@Override
		protected String doInBackground(Integer... params) {

			int m = params[0];
			int i = 0;
			for (i = m; i > 0; i--) {
				publishProgress(i);
				progBar.setProgress(i);

				if (status == false) {
					break;
				}
				// replaces handler
				try {
					Thread.sleep(1000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String s = "counter" + i;

			return s;

		}

		@Override
		protected void onPostExecute(String result) {

			super.onPostExecute(result);

			textResult.setText(result);
			

			Toast.makeText(CountDown.this, "---hurrraaayyya----u-----win---",
					Toast.LENGTH_LONG).show();

		}

		@Override
		protected void onProgressUpdate(Integer... values) {

			super.onProgressUpdate(values);
			int i = values[0];
			textResult.setText("..." + i);
		}

	}

}
