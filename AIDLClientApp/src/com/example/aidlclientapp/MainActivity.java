package com.example.aidlclientapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.util.data.IMath;

public class MainActivity extends ActionBarActivity {

	EditText editX, editY;
	Button btPower, btAdd;
	TextView textResult;
	IMath mathService;
	ServiceConnection serviceConnection;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editX = (EditText) findViewById(R.id.editText1);
		editY = (EditText) findViewById(R.id.editText2);
		btAdd = (Button) findViewById(R.id.button1);
		btPower = (Button) findViewById(R.id.button2);
		textResult = (TextView) findViewById(R.id.textView1);

		// initialize service connection to connect with MathService
		serviceConnection = new MathServiceConnection();
		//implicit intent
		Intent intent = new Intent();
		intent.setAction("com.example.aidlserviceapp.CALCULATE");
		boolean r = bindService(intent, serviceConnection, BIND_AUTO_CREATE);
		
		//explicit intent for android 5.0
		/*Intent in=new Intent().setClassName("com.example.aidlserviceapp","com.example.aidlserviceapp.MathService");
		in.setClassName("com.example.aidlserviceapp", "MathService");*/
		
		btAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					int res = mathService.add(
							Integer.parseInt(editX.getText().toString()),
							Integer.parseInt(editY.getText().toString()));

					textResult.setText(res + "");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btPower.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					int res = mathService.power(
							Integer.parseInt(editX.getText().toString()),
							Integer.parseInt(editY.getText().toString()));

					textResult.setText(res + "");
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

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

	// before eof activity
	class MathServiceConnection implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {

			mathService = IMath.Stub.asInterface(service);
			Toast.makeText(MainActivity.this, "Connected", 5).show();
			textResult.setText("Connected");
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {

			Toast.makeText(MainActivity.this, "Disconnected", 5).show();

		}

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		unbindService(serviceConnection);
	}
}
