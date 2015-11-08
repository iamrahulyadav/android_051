package com.example.bluetoothreceiver;

import java.util.ArrayList;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	TextView text;
	Button btStart;

	ListView list;

	ArrayList<String> listNameAdd = new ArrayList<String>();
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.textView1);
		btStart = (Button) findViewById(R.id.button1);
		list = (ListView) findViewById(R.id.listView1);

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listNameAdd);

		list.setAdapter(adapter);

		final BluetoothAdapter blue = BluetoothAdapter.getDefaultAdapter();

		btStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				blue.startDiscovery();

				IntentFilter filter = new IntentFilter();
				filter.addAction(BluetoothDevice.ACTION_FOUND);
				registerReceiver(new BlueToothReceiver(), filter);

			}
		});

	}

	class BlueToothReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {

			String action = intent.getAction();
			String name, add;

			BluetoothDevice bluetoothdevice = intent
					.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

			if (BluetoothDevice.ACTION_FOUND.equals(action)) {

				name = bluetoothdevice.getName();
				add = bluetoothdevice.getAddress();

				listNameAdd.add(name + ":" + add);
				adapter.notifyDataSetChanged();
			}

		}

	}

}
