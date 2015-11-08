package com.example.androidthreadsample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	Button btGo;
	EditText editNum;
	TextView textNum;
	ProgressBar progBar;

	CountHandler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btGo = (Button) findViewById(R.id.button1);
		editNum = (EditText) findViewById(R.id.editText1);
		textNum = (TextView) findViewById(R.id.textView1);
		progBar = (ProgressBar) findViewById(R.id.progressBar1);

		btGo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String str = editNum.getText().toString();
				int n = Integer.parseInt(str);

				CountThread t = new CountThread(n);

				t.start();

			}
		});

	}

	class CountHandler extends Handler {

		@Override
		public void handleMessage(Message msg) {

			super.handleMessage(msg);

			Bundle bundle = msg.getData();

			int c = bundle.getInt("count");

			textNum.setText("count" + c);

		}

	}

	class CountThread extends Thread {
		int n;

		public CountThread(int n) {
			this.n = n;
		}

		public void run() {

			for (int i = 0; i <= n; i++) {
				// textNum.setText("count" + i);

				Bundle bundle = new Bundle();
				bundle.putInt("count", i);

				Message msg = new Message();
				msg.setData(bundle);

				handler.sendMessage(msg); // ---------------->>>> main thread
											// msgg

				progBar.setProgress(i);

				Log.e("count", i + "");
				try {

					sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}

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
		return super.onOptionsItemSelected(item);
	}
}
