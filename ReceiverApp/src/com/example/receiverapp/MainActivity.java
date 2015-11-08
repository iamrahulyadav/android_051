package com.example.receiverapp;

import java.util.ArrayList;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsMessage;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	TextView textData;
	ListView listViewSMS;
	ArrayList<String> listSMS = new ArrayList<String>();
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		textData = (TextView) findViewById(R.id.textView1);

		
		// intent
		
		Intent intent = getIntent();
		String str = intent.getStringExtra("newdata");
		
		textData.setText(str);
		listViewSMS = (ListView) findViewById(R.id.listView1);

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listSMS);

		listViewSMS.setAdapter(adapter);
		
		//register receiver
		
		IntentFilter filter=new IntentFilter();
		filter.addAction("android.provider.Telephony.SMS_RECEIVED");
		registerReceiver(new NewSMSReceiver(), filter);
		
		
		

	}// eof create

	class NewSMSReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			Object smsObjects[] = (Object[]) intent.getExtras().get("pdus");

			// convert first sms in byte array
			byte smsData[] = (byte[]) smsObjects[0];

			// convert byte sequence in proper smsMessage
			SmsMessage sms = SmsMessage.createFromPdu(smsData);
			String body = sms.getMessageBody();
			String number = sms.getOriginatingAddress();

			listSMS.add(number + ":" + body);
			adapter.notifyDataSetChanged();

			// Toast.makeText(context, body + ":from:" + number, 5).show();

		}

	}

}
