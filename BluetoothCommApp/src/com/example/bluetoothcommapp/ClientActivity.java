package com.example.bluetoothcommapp;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ClientActivity extends Activity {

	EditText editMsg;
	ListView listViewDevice;
	Button btSend;

	ArrayList<String> listDeviceName = new ArrayList<String>();

	ArrayAdapter<String> adapter;

	BluetoothAdapter btAdapter;

	BluetoothSocket dataSocket;
	DeviceInfoReceiver receiver=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.client);

		editMsg = (EditText) findViewById(R.id.editText1);

		listViewDevice = (ListView) findViewById(R.id.listView1);

		btSend = (Button) findViewById(R.id.button1);

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listDeviceName);

		listViewDevice.setAdapter(adapter);

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
				
				registerBTReceiver();
				btAdapter.startDiscovery();
			}

		}

		// list item click

		listViewDevice.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				String info = adapter.getItem(arg2);

				String ar[] = info.split(",");

				String address = ar[1];

				// instantiate device

				BluetoothDevice btDevice = btAdapter.getRemoteDevice(address);

				// start a thread to send connection rqst
				btAdapter.cancelDiscovery();

				ConnectionThread thread = new ConnectionThread(btDevice);
				thread.start();

			}

		});

		btSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String msg = editMsg.getText().toString();

				if (dataSocket != null) {

					SendMessage task = new SendMessage();

					task.execute(msg);
				}

			}
		});

	} // eof onCreate

	class ConnectionThread extends Thread {

		BluetoothDevice btDevice;

		public ConnectionThread(BluetoothDevice btDevice) {
			// TODO Auto-generated constructor stub

			this.btDevice = btDevice;

		}

		public void run() {
			
			UUID uuid = UUID.fromString("00000000-0000-0000-0000-0123456789AB");

			try {

				dataSocket = btDevice.createRfcommSocketToServiceRecord(uuid);
				
				dataSocket.connect();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				Log.e("error:", "connection failed");

				dataSocket = null;
				return;
			}// eof try catch

			Log.e("succes:", "connection made");

		}

	}

	class SendMessage extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			String msg = params[0];

			try {
				OutputStream fout = dataSocket.getOutputStream();

				PrintStream printStream = new PrintStream(fout);

				printStream.println(msg);
				printStream.flush();
				//printStream.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "done";
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);

			Toast.makeText(ClientActivity.this, result, 5).show();

		}

	}

	void registerBTReceiver() {
		IntentFilter filter = new IntentFilter();
		filter.addAction(BluetoothDevice.ACTION_FOUND);
		receiver=new DeviceInfoReceiver();
		registerReceiver(receiver, filter);
	}

	void unregisterBTReceiver() {
		
		
		unregisterReceiver(receiver);
	}
	
	class DeviceInfoReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub

			// match the action bl found

			if (intent.getAction().equals(BluetoothDevice.ACTION_FOUND)) {

				BluetoothDevice device = intent
						.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

				String deviceName = device.getName();
				String deviceAdd = device.getAddress();

				listDeviceName.add(deviceName + "," + deviceAdd);

				adapter.notifyDataSetChanged();

			}

		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 101 && btAdapter.isEnabled()) {
			registerBTReceiver();
			btAdapter.startDiscovery();
		}

	}
@Override
protected void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	
	//unregisterBTReceiver();
}
}
