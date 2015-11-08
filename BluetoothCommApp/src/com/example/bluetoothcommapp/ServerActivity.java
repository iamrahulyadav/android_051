package com.example.bluetoothcommapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ServerActivity extends Activity

{

	TextView TextMsg;
	BluetoothAdapter btAdapter;
	BluetoothSocket dataSocket;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.server);
		
		TextMsg = (TextView) findViewById(R.id.textView1);

		btAdapter = BluetoothAdapter.getDefaultAdapter();
		if (btAdapter == null) {
			Toast.makeText(this, "no bluetooth support", 3).show();
			finish();
		}

		else // chk for btEnable
		{

			if (!btAdapter.isEnabled()) {
				Intent inEnable = new Intent(
						BluetoothAdapter.ACTION_REQUEST_ENABLE);
				startActivityForResult(inEnable, 101);
			}
			// already enable
			else {
				// start listening to client request
				// start a thread to connect with client
				
				ClientConnectionTask task=new ClientConnectionTask();
				task.execute();
				
				
				
				
			}

		}

	}// eof oncreate

	class ClientConnectionTask extends AsyncTask<Void, String, String> {

		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
			UUID uuid = UUID.fromString("00000000-0000-0000-0000-0123456789AB");
			try {
				BluetoothServerSocket serverSocket = btAdapter
						.listenUsingRfcommWithServiceRecord("mycon", uuid);
				dataSocket = serverSocket.accept();

				
				if (dataSocket != null) {
					publishProgress("conected");
					
					InputStream in = dataSocket.getInputStream();
					InputStreamReader reader = new InputStreamReader(in);
					
					BufferedReader br = new BufferedReader(reader);
					
					String msg = "";
					while (true) {
						msg = br.readLine();
						publishProgress(msg);
					//	Thread.sleep(500);
					
						if(msg.equals("bye"))
						{
							break;
						}
					}

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "done";
		}// eof doInBack

		@Override
		protected void onProgressUpdate(String... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);

			TextMsg.setText(values[0]);

		}

	}// eof AsyncTasdk

}
